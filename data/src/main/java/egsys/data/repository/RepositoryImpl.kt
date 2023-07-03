package egsys.data.repository

import android.content.Context
import android.util.Log
import egsys.data.api.Service
import egsys.data.data.DataManager.addElementInListDetails
import egsys.data.data.DataManager.getElementById
import egsys.data.data.DataManager.getOriginalListPokemons
import egsys.data.data.DataManager.getOriginalListType
import egsys.data.data.DataManager.setOriginalListPokemons
import egsys.data.data.DataManager.setOriginalListType
import egsys.data.data.DataManager.withoutElementInList
import egsys.data.util.Internet.isOnline
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity
import egsys.domain.repository.Repository
import retrofit2.awaitResponse

class RepositoryImpl(
    private val service: Service,
    private val context: Context
) : Repository {
    override suspend fun getListOnlyByType(idType: String): List<PokemonEntity> {
        try {
            if (withoutElementInList(idType)) {
                val result = service.getListOnlyByTypes(idType).awaitResponse()
                val listPokemons = result.body()?.pokemon?.map { pokemon ->
                    val id = pokemon.pokemon.url.substring(34).trim { it <= '/' }
                    PokemonEntity(
                        id = id.toInt(),
                        name = pokemon.pokemon.name,
                        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png",
                        details = ""
                    )
                }
                result.body()?.let { addElementInListDetails(it) }
                return listPokemons ?: emptyList()
            } else {
                val elements = getElementById(idType.toInt())
                val listPokemons = elements?.pokemon?.map { element ->
                    val id = element.pokemon.url.substring(34).trim { it <= '/' }
                    PokemonEntity(
                        id = id.toInt(),
                        name = element.pokemon.name,
                        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png",
                        details = ""
                    )
                }
                return listPokemons ?: emptyList()
            }
        } catch (e: Exception) {
            Log.e("testar", "getListOnlyByType: $e")
        }
        return emptyList()
    }

    override suspend fun getListPokemons(): List<PokemonEntity> {
        if (isOnline(context)) {
            val result = service.getListPokemons().awaitResponse()
            val listPokemons: MutableList<PokemonEntity> = mutableListOf()
            //Todo: abstrair logica para outro lugar
            result.body()?.results?.map {
                val id = it.url.substring(34).trim { it <= '/' }
                listPokemons.add(
                    PokemonEntity(
                        id = id.toInt(),
                        name = it.name,
                        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png",
                        details = ""
                    )
                )
            }
            setOriginalListPokemons(listPokemons)
            return getOriginalListPokemons()!!
        } else {
            throw Error("Erro ao obter dados!")
        }
    }

    override suspend fun getListType(): List<TypeEntity> {
        if (isOnline(context)) {
            val listType: MutableList<TypeEntity> = mutableListOf()
            try {
                val result = service.getListTypes().awaitResponse()
                result.body()?.results?.map {
                    val id = it.url.substring(31).trim { it <= '/' }
                    listType.add(
                        TypeEntity(
                            id = id.toInt(),
                            name = it.name
                        )
                    )
                }
            } catch (e: Exception) {
                Log.e("testar", "getListType: $e")
            }
            setOriginalListType(listType)
            return getOriginalListType()!!
        } else {
            throw Error("Erro ao obter dados!")
        }
    }
}
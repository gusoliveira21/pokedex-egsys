package egsys.data.repository

import android.content.Context
import android.util.Log
import egsys.data.api.Service
import egsys.data.util.Internet.isOnline
import egsys.domain.entities.PokemonEntity
import egsys.domain.repository.Repository
import retrofit2.awaitResponse

class RepositoryImpl(
    private val service: Service,
    private val context: Context
) : Repository {

    override suspend fun getListPokemons(): List<PokemonEntity> {
        if (isOnline(context)) {
            val result = service.getListPokemons().awaitResponse()

            val listPokemons: MutableList<PokemonEntity> = mutableListOf()
            //Todo: abstrair logica para outro lugar
            result.body()?.results?.map {
                val id = it.url.substring(34).trim { it <= '/' }
                listPokemons.add(
                    PokemonEntity(
                        id = id,
                        name = it.name,
                        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png",
                        details = ""
                    )
                )
            }
            return listPokemons
        } else {
            throw Error("Erro ao obter dados!")
        }
    }

}
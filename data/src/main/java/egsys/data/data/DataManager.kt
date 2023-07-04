package egsys.data.data

import egsys.data.model.detailsType.DetailsType
import egsys.data.model.pokemonDetails.PokemonDetails
import egsys.domain.entities.PokemonDetailEntity
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity

object DataManager {
    private var originalListPokemons: List<PokemonEntity>? = null
    private var listType: List<TypeEntity>? = null
    private var listDetailsType: MutableList<List<DetailsType>> = mutableListOf()
    private var pokemonsDetailsList: MutableList<List<PokemonDetailEntity>> = mutableListOf()

    fun setOriginalListPokemons(list: List<PokemonEntity>) {
        if (originalListPokemons.isNullOrEmpty()) originalListPokemons = list
    }

    fun getOriginalListPokemons() = originalListPokemons

    fun setOriginalListType(list: List<TypeEntity>) {
        if (listType.isNullOrEmpty()) listType = list
    }

    fun getOriginalListType() = listType

    fun withoutElementInList(idType: String): Boolean {
        var valor: Boolean = true
        listDetailsType?.forEach { list -> if (list[0].id == idType.toInt()) valor = false }
        return valor
    }

    fun addElementInListDetails(element: DetailsType) {
        listDetailsType.add(listOf(element))
    }

    fun getElementById(id: Int): DetailsType? {
        return listDetailsType.flatten().find { it.id == id }
    }

    fun setPokemonsDetailsAtList(details: PokemonDetails) {
        var list: MutableList<String>? = mutableListOf()

        details.types?.forEach {
            it?.type?.name?.let { it1 ->
                list?.add(
                    it1
                )
            }
        }
        pokemonsDetailsList.add(
            listOf(
                PokemonDetailEntity(
                    name = details.name,
                    height = details.height,
                    image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${details.id}.png",
                    weight = details.weight,
                    type = list,
                    id = details.id
                )
            )
        )
    }

    fun findPokemonDetailById(id: Int): Boolean {
        return pokemonsDetailsList.any { pokemonDetail -> pokemonDetail.any { it.id == id } }
    }

    fun getPokemonDetailById(id: Int): PokemonDetailEntity? {
        return pokemonsDetailsList.flatten().find { it.id == id }
    }

}
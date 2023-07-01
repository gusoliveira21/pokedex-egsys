package egsys.domain.repository

import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity

interface Repository {
    suspend fun getListPokemons() : List<PokemonEntity>
    suspend fun getListType() : List<TypeEntity>
}
package egsys.domain.repository

import egsys.domain.entities.PokemonDetailEntity
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity

interface Repository {
    suspend fun getListPokemons() : List<PokemonEntity>
    suspend fun getListType() : List<TypeEntity>
    suspend fun getListOnlyByType(idType: String) : List<PokemonEntity>
    suspend fun getOnlyOnePoke(nameId: String) : PokemonDetailEntity?
    suspend fun getOneRandomPoke() : List<PokemonEntity>?
}
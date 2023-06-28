package egsys.domain.repository

import egsys.domain.entities.PokemonEntity

interface Repository {
    suspend fun getListPokemons() : List<PokemonEntity>
}
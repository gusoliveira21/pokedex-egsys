package egsys.domain.usecase.home

import egsys.domain.entities.PokemonEntity
import egsys.domain.repository.Repository
import egsys.domain.usecase.base.BaseUseCase

class GetListUseCase(private val repository: Repository) : BaseUseCase<Unit, List<PokemonEntity>>() {
    override suspend fun doWork(value: Unit?): List<PokemonEntity> {
        return try {
            repository.getListPokemons()
        }catch (e: Exception){
            throw Error("Erro na requisição!")
        }
    }
}
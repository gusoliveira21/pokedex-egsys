package egsys.domain.usecase.base

import egsys.domain.entities.PokemonEntity
import egsys.domain.repository.Repository

class GetListUseCase(private val repository: Repository) : BaseUseCase<Unit, List<PokemonEntity>>() {
    override suspend fun doWork(value: Unit?): List<PokemonEntity> {
        return repository.getListPokemons()
    }
}
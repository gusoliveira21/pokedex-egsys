package egsys.domain.usecase.detail

import egsys.domain.entities.PokemonDetailEntity
import egsys.domain.entities.PokemonEntity
import egsys.domain.repository.Repository
import egsys.domain.usecase.base.BaseUseCase

class GetOnlyOnePokeUseCase (private val repository: Repository) :
    BaseUseCase<String?, PokemonDetailEntity?>() {
    override suspend fun doWork(value: String?): PokemonDetailEntity? {
        return if(value != null){
            repository.getOnlyOnePoke(value)
        } else
            throw Error("Erro na requisição!")
    }
}
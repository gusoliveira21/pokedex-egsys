package egsys.domain.usecase.home

import egsys.domain.entities.PokemonEntity
import egsys.domain.repository.Repository
import egsys.domain.usecase.base.BaseUseCase

class GetListOnlyByTypeUseCase(private val repository: Repository) :
    BaseUseCase<String?, List<PokemonEntity>>() {

    override suspend fun doWork(value: String?): List<PokemonEntity> {
        return if (value != null) {
                repository.getListOnlyByType(value)
            } else
            throw Error("Erro na requisição!")
    }
}
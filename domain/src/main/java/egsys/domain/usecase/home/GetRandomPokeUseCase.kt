package egsys.domain.usecase.home

import egsys.domain.repository.Repository
import egsys.domain.usecase.base.BaseUseCase

class GetRandomPokeUseCase(private val repository: Repository) : BaseUseCase<Unit?, Int?>() {
    override suspend fun doWork(value: Unit?): Int? {
        return try {
            repository.getOneRandomPoke()?.random()?.id
        } catch (e: Exception) {
            throw Error("Erro na requisição!")
        }
    }
}
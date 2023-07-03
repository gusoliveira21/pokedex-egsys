package egsys.domain.usecase.home

import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.SearchEntity
import egsys.domain.repository.Repository
import egsys.domain.usecase.base.BaseUseCase

class GetListWithNameAndTypeUseCase(private val repository: Repository) :
    BaseUseCase<List<SearchEntity>?, List<PokemonEntity>>() {
    override suspend fun doWork(value: List<SearchEntity>?): List<PokemonEntity> {
        return try {
            var id = ""
            var startString = ""
            value?.forEach {
                id = it.id
                startString = it.name.uppercase()
            }
            val result = repository.getListOnlyByType(id)
            val (filterResult, rest) = result.partition { pokemon ->
                pokemon.name.startsWith(startString, ignoreCase = true)
            }
            filterResult + rest
        } catch (e: Exception) {
            throw Error("Erro na requisição!")
        }
    }
}
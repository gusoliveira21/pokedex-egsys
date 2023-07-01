package egsys.domain.usecase.home

import egsys.domain.entities.TypeEntity
import egsys.domain.repository.Repository
import egsys.domain.usecase.base.BaseUseCase

class GetListTypeUseCase(private val repository: Repository) : BaseUseCase<Unit, List<TypeEntity>>(){
    override suspend fun doWork(value: Unit?): List<TypeEntity> {
        return try {
            repository.getListType()
        }catch(e: Exception){
            throw Error("Erro na requisição!")
        }
    }
}
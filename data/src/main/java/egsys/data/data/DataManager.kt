package egsys.data.data

import android.util.Log
import com.squareup.moshi.Json
import egsys.data.model.detailsType.DamageRelations
import egsys.data.model.detailsType.DetailsType
import egsys.data.model.detailsType.GameIndices
import egsys.data.model.detailsType.Generation
import egsys.data.model.detailsType.MoveDamageClass
import egsys.data.model.detailsType.Moves
import egsys.data.model.detailsType.Names
import egsys.data.model.detailsType.Pokemon
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity

object DataManager {
        private var originalListPokemons: List<PokemonEntity>? = null
        private var listType: List<TypeEntity>? = null
        private var listDetailsType: MutableList<List<DetailsType>> = mutableListOf()

        fun setOriginalListPokemons(list: List<PokemonEntity>) {
            if (originalListPokemons.isNullOrEmpty()) originalListPokemons = list
        }
        fun getOriginalListPokemons() = originalListPokemons

        fun setOriginalListType(list: List<TypeEntity>) {
            if (listType.isNullOrEmpty()) listType = list
        }
        fun getOriginalListType() = listType

        fun withoutElementInList(idType: String): Boolean{
            var valor : Boolean = true
            listDetailsType?.forEach { list ->  if (list[0].id == idType.toInt()) valor = false }
            return valor
        }
        fun addElementInListDetails(element: DetailsType){
            listDetailsType.add(listOf(element))
        }

        fun getElementById(id: Int): DetailsType? {
            return listDetailsType.flatten().find { it.id == id }
        }

}
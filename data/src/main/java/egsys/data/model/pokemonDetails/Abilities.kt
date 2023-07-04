package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Abilities (

  @field:Json(name = "ability"   ) var ability  : Ability? = Ability(),
  @field:Json(name = "is_hidden" ) var isHidden : Boolean? = null,
  @field:Json(name = "slot"      ) var slot     : Int?     = null

)
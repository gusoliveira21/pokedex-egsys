package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Icons (

  @field:Json(name = "front_default" ) var frontDefault : String? = null,
  @field:Json(name = "front_female"  ) var frontFemale  : String? = null

)
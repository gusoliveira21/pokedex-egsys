package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Types (

  @field:Json(name = "slot" ) var slot : Int?  = null,
  @field:Json(name = "type" ) var type : Type? = Type()

)
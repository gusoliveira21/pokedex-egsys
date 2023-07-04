package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationI (

  @field:Json(name = "red-blue" ) var redBlue : RedBlue? = RedBlue(),
  @field:Json(name = "yellow"   ) var yellow   : Yellow?   = Yellow()

)
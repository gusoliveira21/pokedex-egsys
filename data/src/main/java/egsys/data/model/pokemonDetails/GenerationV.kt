package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationV (

  @field:Json(name = "black-white" ) var blackWhite : BlackWhite? = BlackWhite()

)
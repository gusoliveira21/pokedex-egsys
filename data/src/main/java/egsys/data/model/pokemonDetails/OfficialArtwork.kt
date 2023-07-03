package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class OfficialArtwork (

  @field:Json(name = "front_default" ) var frontDefault : String? = null,
  @field:Json(name = "front_shiny"   ) var frontShiny   : String? = null

)
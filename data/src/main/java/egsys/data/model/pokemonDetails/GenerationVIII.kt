package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationVIII (

  @field:Json(name = "icons" ) var icons : Icons? = Icons()

)
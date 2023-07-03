package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationII (

  @field:Json(name = "crystal" ) var crystal : Crystal? = Crystal(),
  @field:Json(name = "gold"    ) var gold    : Gold?    = Gold(),
  @field:Json(name = "silver"  ) var silver  : Silver?  = Silver()

)
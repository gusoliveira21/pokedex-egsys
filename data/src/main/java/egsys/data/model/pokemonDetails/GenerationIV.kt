package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationIV (

  @field:Json(name = "diamond-pearl"        ) var diamondPearl        : DiamondPearl?        = DiamondPearl(),
  @field:Json(name = "heartgold-soulsilver" ) var heartgoldSoulsilver : HeartgoldSoulsilver? = HeartgoldSoulsilver(),
  @field:Json(name = "platinum"             ) var platinum             : Platinum?             = Platinum()

)
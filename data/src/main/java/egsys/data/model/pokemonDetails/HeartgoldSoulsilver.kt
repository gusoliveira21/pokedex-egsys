package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class HeartgoldSoulsilver (

  @field:Json(name = "back_default"       ) var backDefault      : String? = null,
  @field:Json(name = "back_female"        ) var backFemale       : String? = null,
  @field:Json(name = "back_shiny"         ) var backShiny        : String? = null,
  @field:Json(name = "back_shiny_female"  ) var backShinyFemale  : String? = null,
  @field:Json(name = "front_default"      ) var frontDefault     : String? = null,
  @field:Json(name = "front_female"       ) var frontFemale      : String? = null,
  @field:Json(name = "front_shiny"        ) var frontShiny       : String? = null,
  @field:Json(name = "front_shiny_female" ) var frontShinyFemale : String? = null

)
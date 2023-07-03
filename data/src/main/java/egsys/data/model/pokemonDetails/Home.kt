package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Home (

  @field:Json(name = "front_default"      ) var frontDefault     : String? = null,
  @field:Json(name = "front_female"       ) var frontFemale      : String? = null,
  @field:Json(name = "front_shiny"        ) var frontShiny       : String? = null,
  @field:Json(name = "front_shiny_female" ) var frontShinyFemale : String? = null

)
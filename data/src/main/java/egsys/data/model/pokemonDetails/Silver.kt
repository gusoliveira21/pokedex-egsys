package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Silver (

  @field:Json(name = "back_default"      ) var backDefault      : String? = null,
  @field:Json(name = "back_shiny"        ) var backShiny        : String? = null,
  @field:Json(name = "front_default"     ) var frontDefault     : String? = null,
  @field:Json(name = "front_shiny"       ) var frontShiny       : String? = null,
  @field:Json(name = "front_transparent" ) var frontTransparent : String? = null

)
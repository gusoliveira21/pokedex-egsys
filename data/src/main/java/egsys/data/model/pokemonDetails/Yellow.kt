package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Yellow (

  @field:Json(name = "back_default"      ) var backDefault      : String? = null,
  @field:Json(name = "back_gray"         ) var backGray         : String? = null,
  @field:Json(name = "back_transparent"  ) var backTransparent  : String? = null,
  @field:Json(name = "front_default"     ) var frontDefault     : String? = null,
  @field:Json(name = "front_gray"        ) var frontGray        : String? = null,
  @field:Json(name = "front_transparent" ) var frontTransparent : String? = null

)
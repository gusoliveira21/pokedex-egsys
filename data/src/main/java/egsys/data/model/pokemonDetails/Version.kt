package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Version (

  @field:Json(name = "name" ) var name : String? = null,
  @field:Json(name = "url"  ) var url  : String? = null

)
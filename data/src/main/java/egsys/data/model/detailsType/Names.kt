package egsys.data.model.detailsType

import com.squareup.moshi.Json

data class Names (

  @field:Json(name = "language" ) var language : Language?,
  @field:Json(name = "name"     ) var name     : String?

)
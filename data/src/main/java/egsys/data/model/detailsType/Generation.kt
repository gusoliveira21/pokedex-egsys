package egsys.data.model.detailsType

import com.squareup.moshi.Json

data class Generation (

  @field:Json(name = "name" ) val name : String,
  @field:Json(name = "url"  ) val url  : String

)
package egsys.data.model.detailsType

import com.squareup.moshi.Json

data class HalfDamageTo (

  @field:Json(name = "name" ) var name : String?,
  @field:Json(name = "url"  ) var url  : String?

)
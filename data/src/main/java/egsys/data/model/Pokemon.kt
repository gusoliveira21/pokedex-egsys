package egsys.data.model

import com.squareup.moshi.Json

data class Pokemon(
    @field:Json(name = "url") val url: String,
    @field:Json(name = "name") val name: String
)

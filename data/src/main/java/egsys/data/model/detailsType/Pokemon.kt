package egsys.data.model.detailsType

import com.squareup.moshi.Json
import egsys.data.model.pokemon.Pokemon

data class Pokemon (
  @field:Json(name = "pokemon" ) var pokemon : Pokemon,
  @field:Json(name = "slot"    ) var slot    : Int?
)
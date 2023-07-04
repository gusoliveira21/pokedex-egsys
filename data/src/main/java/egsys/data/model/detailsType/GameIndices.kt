package egsys.data.model.detailsType

import com.squareup.moshi.Json

data class GameIndices (

  @field:Json(name = "game_index" ) val gameIndex  : Int,
  @field:Json(name = "generation" ) val generation : Generation

)
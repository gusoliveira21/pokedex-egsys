package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GameIndices (

  @field:Json(name = "game_index" ) var gameIndex : Int?     = null,
  @field:Json(name = "version"    ) var version   : Version? = Version()

)
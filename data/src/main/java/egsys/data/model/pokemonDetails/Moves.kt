package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Moves (

  @field:Json(name = "move"                  ) var move                : Move?                          = Move(),
  @field:Json(name = "version_group_details" ) var versionGroupDetails : List<VersionGroupDetails> = arrayListOf()

)
package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class VersionGroupDetails (

  @field:Json(name = "level_learned_at"  ) var levelLearnedAt  : Int?             = null,
  @field:Json(name = "move_learn_method" ) var moveLearnMethod : MoveLearnMethod? = MoveLearnMethod(),
  @field:Json(name = "version_group"     ) var versionGroup    : VersionGroup?    = VersionGroup()

)
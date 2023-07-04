package egsys.data.model.detailsType

import com.squareup.moshi.Json

data class DetailsType (
  @field:Json(name = "damage_relations"      ) val damageRelations     : DamageRelations?,
  @field:Json(name = "game_indices"          ) val gameIndices         : List<GameIndices>?,
  @field:Json(name = "generation"            ) val generation          : Generation?,
  @field:Json(name = "id"                    ) val id                  : Int?,
  @field:Json(name = "move_damage_class"     ) val moveDamageClass     : MoveDamageClass?,
  @field:Json(name = "moves"                 ) val moves               : List<Moves>,
  @field:Json(name = "name"                  ) val name                : String?,
  @field:Json(name = "names"                 ) val names               : List<Names>?,
  @field:Json(name = "past_damage_relations" ) val pastDamageRelations : List<String>?,
  @field:Json(name = "pokemon"               ) val pokemon             : List<Pokemon>?
)
package egsys.data.model.detailsType

import com.squareup.moshi.Json

data class DamageRelations (

  @field:Json(name = "double_damage_from" ) var doubleDamageFrom : List<DoubleDamageFrom>,
  @field:Json(name = "double_damage_to"   ) var doubleDamageTo   : List<String>,
  @field:Json(name = "half_damage_from"   ) var halfDamageFrom   : List<String>,
  @field:Json(name = "half_damage_to"     ) var halfDamageTo     : List<HalfDamageTo>,
  @field:Json(name = "no_damage_from"     ) var noDamageFrom     : List<NoDamageFrom>,
  @field:Json(name = "no_damage_to"       ) var noDamageTo       : List<NoDamageTo>

)
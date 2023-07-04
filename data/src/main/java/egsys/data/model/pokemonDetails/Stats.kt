package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Stats (

  @field:Json(name = "base_stat" ) var baseStat : Int?  = null,
  @field:Json(name = "effort"    ) var effort   : Int?  = null,
  @field:Json(name = "stat"      ) var stat     : Stat? = Stat()

)
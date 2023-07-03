package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Other (

  @field:Json(name = "dream_world"      ) var dreamWorld       : DreamWorld?       = DreamWorld(),
  @field:Json(name = "home"             ) var home             : Home?             = Home(),
  @field:Json(name = "official-artwork" ) var officialArtwork : OfficialArtwork? = OfficialArtwork()

)
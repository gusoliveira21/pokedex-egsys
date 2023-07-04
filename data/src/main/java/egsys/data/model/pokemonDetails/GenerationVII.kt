package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationVII (

  @field:Json(name = "icons"                ) var icons                : Icons?                = Icons(),
  @field:Json(name = "ultra-sun-ultra-moon" ) var ultraSunUltraMoon : UltraSunUltraMoon? = UltraSunUltraMoon()

)
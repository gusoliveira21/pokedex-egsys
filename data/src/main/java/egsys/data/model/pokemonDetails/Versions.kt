package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class Versions (

  @field:Json(name = "generation-i"    ) var generationI    : GenerationI?    = GenerationI(),
  @field:Json(name = "generation-ii"   ) var generationII   : GenerationII?   = GenerationII(),
  @field:Json(name = "generation-iii"  ) var generationIII  : GenerationIII?  = GenerationIII(),
  @field:Json(name = "generation-iv"   ) var generationIV   : GenerationIV?   = GenerationIV(),
  @field:Json(name = "generation-v"    ) var generationV    : GenerationV?    = GenerationV(),
  @field:Json(name = "generation-vi"   ) var generationVI   : GenerationVI?   = GenerationVI(),
  @field:Json(name = "generation-vii"  ) var generationVII  : GenerationVII?  = GenerationVII(),
  @field:Json(name = "generation-viii" ) var generationVIII : GenerationVIII? = GenerationVIII()

)
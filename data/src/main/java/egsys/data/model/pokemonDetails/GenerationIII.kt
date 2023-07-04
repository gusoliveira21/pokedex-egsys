package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationIII (

  @field:Json(name = "emerald"           ) var emerald           : Emerald?           = Emerald(),
  @field:Json(name = "firered-leafgreen" ) var fireredLeafgreen : FireredLeafgreen? = FireredLeafgreen(),
  @field:Json(name = "ruby-sapphire"     ) var rubySapphire     : RubySapphire?     = RubySapphire()

)
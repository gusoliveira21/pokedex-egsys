package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class GenerationVI (

  @field:Json(name = "omegaruby-alphasapphire" ) var omegarubyAlphasapphire : OmegarubyAlphasapphire? = OmegarubyAlphasapphire(),
  @field:Json(name = "x-y"                     ) var xy                     : Xy?                     = Xy()

)
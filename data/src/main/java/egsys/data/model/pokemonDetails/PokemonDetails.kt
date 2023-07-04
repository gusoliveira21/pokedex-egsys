package egsys.data.model.pokemonDetails

import com.squareup.moshi.Json


data class PokemonDetails (

  @field:Json(name = "abilities"                ) val abilities              : List<Abilities>?,
  @field:Json(name = "base_experience"          ) val baseExperience         : Int?,
  @field:Json(name = "forms"                    ) val forms                  : List<Forms>?,
  @field:Json(name = "game_indices"             ) val gameIndices            : List<GameIndices>?,
  @field:Json(name = "height"                   ) val height                 : Int?,
  @field:Json(name = "held_items"               ) val heldItems              : List<String>?,
  @field:Json(name = "id"                       ) val id                     : Int?,
  @field:Json(name = "is_default"               ) val isDefault              : Boolean?,
  @field:Json(name = "location_area_encounters" ) val locationAreaEncounters : String?,
  @field:Json(name = "moves"                    ) val moves                  : List<Moves>? ,
  @field:Json(name = "name"                     ) val name                   : String?,
  @field:Json(name = "order"                    ) val order                  : Int?,
  @field:Json(name = "past_types"               ) val pastTypes              : List<String>?,
  @field:Json(name = "species"                  ) val species                : Species?,
  @field:Json(name = "sprites"                  ) val sprites                : Sprites?,
  @field:Json(name = "stats"                    ) val stats                  : List<Stats>? ,
  @field:Json(name = "types"                    ) val types                  : List<Types>? ,
  @field:Json(name = "weight"                   ) val weight                 : Int?

)
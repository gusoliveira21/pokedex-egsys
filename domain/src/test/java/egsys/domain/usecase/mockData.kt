package egsys.domain.usecase

import egsys.domain.entities.PokemonDetailEntity
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity

object MockDataManager {
    val listPokemons = listOf(
        PokemonEntity(
            id = 1,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            name = "BULBASAUR",
            details = "description"
        ),
        PokemonEntity(
            id = 2,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
            name = "IVYSAUR",
            details = "description"
        ),
        PokemonEntity(
            id = 3,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
            name = "VENUSAUR",
            details = "description"
        ),
        PokemonEntity(
            id = 4,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            name = "PASSARO",
            details = "description"
        ),
        PokemonEntity(
            id = 5,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png",
            name = "SAPO",
            details = "description"
        )
    )

    val listPokemonsReorganize = listOf(
        PokemonEntity(
            id = 2,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
            name = "IVYSAUR",
            details = "description"
        ),
        PokemonEntity(
            id = 1,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            name = "BULBASAUR",
            details = "description"
        ),
        PokemonEntity(
            id = 3,
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
            name = "VENUSAUR",
            details = "description"
        )
    )

    val listType = listOf(
        TypeEntity(
            id = 0,
            name = "agua",
        ),
        TypeEntity(
            id = 1,
            name = "terra",
        ),
        TypeEntity(
            id = 2,
            name = "fogo",
        ),
        TypeEntity(
            id = 3,
            name = "ar",
        )
    )

    val pokemonA: PokemonEntity? = PokemonEntity(
        id = 1,
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        name = "BULBASAUR",
        details = "description"
    )

    val pokemonB = PokemonEntity(
        id = 2,
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
        name = "IVYSAUR",
        details = "description"
    )

    val pokemonDetEntity = PokemonDetailEntity(
        id = 8,
        height = 7,
        name = "PIKACHU",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png",
        type = emptyList(),
        weight = 10
    )
}

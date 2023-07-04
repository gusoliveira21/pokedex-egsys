package egsys.domain.entities

data class PokemonDetailEntity(
    val id: Int? = 0,
    val height: Int? = 0,
    val name: String? = "",
    val image: String? = "",
    val type: List<String>? = emptyList(),
    val weight: Int? = 0
)
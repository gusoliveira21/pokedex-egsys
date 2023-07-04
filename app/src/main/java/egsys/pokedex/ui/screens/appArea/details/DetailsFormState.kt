package egsys.pokedex.ui.screens.appArea.details

data class DetailsFormState(
    val image: String? = "",
    val name: String? = "",
    val height: Int? = 0,
    val weight: Int? = 0,
    val type: List<String>? = emptyList(),
    val load: Boolean = false
)

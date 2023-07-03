package egsys.pokedex.ui.screens.appArea.home

data class SearchFormState (
    val searchInput: String = "",
    var searchDropDown: String = "",
    var reset: Boolean = false,
)

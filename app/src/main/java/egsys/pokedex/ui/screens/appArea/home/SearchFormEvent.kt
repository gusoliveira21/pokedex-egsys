package egsys.pokedex.ui.screens.appArea.home

sealed class SearchFormEvent{
    data class SearchInputChanged(val name: String): SearchFormEvent()
    data class SearchDropDownMenuChanged(val idType: String): SearchFormEvent()
    data class ResetChanged(val reset: Boolean): SearchFormEvent()
    object SearchButton : SearchFormEvent()
    object CleanSearchButton : SearchFormEvent()
}
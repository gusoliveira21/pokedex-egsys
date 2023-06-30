package egsys.pokedex.ui.base

sealed class ValidationEvent{
    object Success : ValidationEvent()
    object Failed : ValidationEvent()
}

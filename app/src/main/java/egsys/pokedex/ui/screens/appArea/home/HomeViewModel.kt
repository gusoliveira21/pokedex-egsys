package egsys.pokedex.ui.screens.appArea.home

import androidx.lifecycle.ViewModel
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity
import egsys.pokedex.ui.base.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class HomeViewModel: ViewModel() {
    abstract var state : SearchFormState
    abstract val message : StateFlow<String?>

    abstract val resultTakePokemons : StateFlow<List<PokemonEntity>?>
    abstract val resultTakeTypes : StateFlow<List<TypeEntity>?>

    abstract val validationEventChannel: Channel<ValidationEvent>
    open val validationEvents: Flow<ValidationEvent>
        get() = validationEventChannel.receiveAsFlow()

    abstract fun onEvent(event: SearchFormEvent)
    abstract fun getListPokemons()
    abstract fun getListType()
    abstract fun getListOnlyByType()
    abstract fun getListByTypeAndName()
}
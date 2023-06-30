package egsys.pokedex.ui.screens.appArea.home

import androidx.lifecycle.ViewModel
import egsys.domain.entities.PokemonEntity
import egsys.pokedex.ui.base.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class HomeViewModel: ViewModel() {
    abstract val message : StateFlow<String?>
    abstract val result : StateFlow<List<PokemonEntity>?>

    abstract val validationEventChannel: Channel<ValidationEvent>
    open val validationEvents: Flow<ValidationEvent>
        get() = validationEventChannel.receiveAsFlow()

    abstract fun submitData()
}
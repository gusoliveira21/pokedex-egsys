package egsys.pokedex.ui.screens.appArea.details

import androidx.lifecycle.ViewModel
import egsys.pokedex.ui.base.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class DetailViewModel : ViewModel() {
    abstract var state : DetailsFormState
    abstract val message : StateFlow<String?>

    abstract val validationEventChannel: Channel<ValidationEvent>
    open val validationEvents: Flow<ValidationEvent>
        get() = validationEventChannel.receiveAsFlow()

    abstract fun fetchData(param: String?)

}
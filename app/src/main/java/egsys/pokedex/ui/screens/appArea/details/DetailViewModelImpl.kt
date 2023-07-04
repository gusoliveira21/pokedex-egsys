package egsys.pokedex.ui.screens.appArea.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import egsys.domain.entities.PokemonDetailEntity
import egsys.domain.usecase.detail.GetOnlyOnePokeUseCase
import egsys.pokedex.ui.base.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class DetailViewModelImpl(
    private val getOnlyOnePokemon: GetOnlyOnePokeUseCase
) : DetailViewModel() {
    override var state by mutableStateOf(DetailsFormState())

    override val validationEventChannel = Channel<ValidationEvent>()
    override val validationEvents = validationEventChannel.receiveAsFlow()

    override val message: StateFlow<String?>
        get() = setMessage
    private val setMessage: MutableStateFlow<String?> = MutableStateFlow(null)

    private fun successTakePokemon(result: PokemonDetailEntity?) {
        viewModelScope.launch {
            state = result.let {
                state.copy(
                    image = it?.image,
                    name = result?.name,
                    height = result?.height,
                    weight = result?.weight,
                    type = result?.type
                )
            }
            state = state.copy(load = false)
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    private fun failure(message: Throwable?) {
        setMessage.value = message?.message
        if (message is Error) {
            setMessage.value = message.message.toString()
            viewModelScope.launch { validationEventChannel.send(ValidationEvent.Failed) }
        } else {
            setMessage.value = "Erro desconhecido!"
            viewModelScope.launch { validationEventChannel.send(ValidationEvent.Failed) }
        }
    }

    override fun fetchData(param: String?) {
        state = state.copy(load = true)
        viewModelScope.launch {
            val result = getOnlyOnePokemon.execute(param)
            result.handleResult(::successTakePokemon, ::failure)
        }
    }
}
package egsys.pokedex.ui.screens.appArea.home

import androidx.lifecycle.viewModelScope
import egsys.domain.entities.PokemonEntity
import egsys.domain.usecase.home.GetListUseCase
import egsys.pokedex.ui.base.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModelImpl(private val getListUseCase: GetListUseCase) : HomeViewModel() {

    override val validationEventChannel = Channel<ValidationEvent>()
    override val validationEvents = validationEventChannel.receiveAsFlow()

    override val message: StateFlow<String?>
        get() = setMessage
    private val setMessage: MutableStateFlow<String?> = MutableStateFlow(null)

    override val result: StateFlow<List<PokemonEntity>?>
        get() = setResult
    private var setResult: MutableStateFlow<List<PokemonEntity>?> = MutableStateFlow(null)

    init {
        if (result.value.isNullOrEmpty())
            submitData()
        else success(result.value!!)
    }

    fun success(result: List<PokemonEntity>) {
        setResult.value = result
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    fun failure(message: Throwable?) {
        setMessage.value = message?.message
        if (message is Error) {
            setMessage.value = message.message.toString()
            viewModelScope.launch { validationEventChannel.send(ValidationEvent.Failed) }
        } else {
            setMessage.value = "Erro desconhecido!"
            viewModelScope.launch { validationEventChannel.send(ValidationEvent.Failed) }
        }
    }

    override fun submitData() {
        viewModelScope.launch {
            val result = getListUseCase.execute(null)
            result.handleResult(::success, ::failure)
        }

    }
}
package egsys.pokedex.ui.screens.appArea.home

import androidx.lifecycle.viewModelScope
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity
import egsys.domain.usecase.home.GetListTypeUseCase
import egsys.domain.usecase.home.GetListPokemonsUseCase
import egsys.pokedex.ui.base.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val getListPokemonsUseCase: GetListPokemonsUseCase,
    private val getListTypeUseCase: GetListTypeUseCase,
    ) : HomeViewModel() {

    override val validationEventChannel = Channel<ValidationEvent>()
    override val validationEvents = validationEventChannel.receiveAsFlow()

    override val message: StateFlow<String?>
        get() = setMessage
    private val setMessage: MutableStateFlow<String?> = MutableStateFlow(null)

    override val resultTakePokemons: StateFlow<List<PokemonEntity>?>
        get() = setResultTakePokemons
    private var setResultTakePokemons: MutableStateFlow<List<PokemonEntity>?> = MutableStateFlow(null)

    override val resultTakeTypes: StateFlow<List<TypeEntity>?>
        get() = setResultTakeTypes
    private var setResultTakeTypes: MutableStateFlow<List<TypeEntity>?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            if (resultTakePokemons.value.isNullOrEmpty()) getListPokemons()
            else successTakePokemons(resultTakePokemons.value!!)
        }


        if(resultTakeTypes.value.isNullOrEmpty()) getListType()
        else successTakeTypes(resultTakeTypes.value!!)

    }

    private fun successTakePokemons(result: List<PokemonEntity>) {
        setResultTakePokemons.value = result
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    private fun successTakeTypes(result: List<TypeEntity>){
        setResultTakeTypes.value = result
        viewModelScope.launch {
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

    override fun getListType() {
        viewModelScope.launch {
            val result = getListTypeUseCase.execute(null)
            result.handleResult(::successTakeTypes, ::failure)
        }
    }
    override fun getListPokemons() {
        viewModelScope.launch {
            val result = getListPokemonsUseCase.execute(null)
            result.handleResult(::successTakePokemons, ::failure)
        }

    }
}
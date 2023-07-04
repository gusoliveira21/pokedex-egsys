package egsys.pokedex.ui.screens.appArea.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.SearchEntity
import egsys.domain.entities.TypeEntity
import egsys.domain.usecase.home.GetListOnlyByTypeUseCase
import egsys.domain.usecase.home.GetListPokemonsUseCase
import egsys.domain.usecase.home.GetListTypeUseCase
import egsys.domain.usecase.home.GetListWithNameAndTypeUseCase
import egsys.domain.usecase.home.GetRandomPokeUseCase
import egsys.pokedex.ui.base.ValidationEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val getListPokemonsUseCase: GetListPokemonsUseCase,
    private val getListTypeUseCase: GetListTypeUseCase,
    private val getListByType: GetListOnlyByTypeUseCase,
    private val getListWithNameAndTypeUseCase: GetListWithNameAndTypeUseCase,
    private val getRandomPokeUseCase: GetRandomPokeUseCase
) : HomeViewModel() {
    //TODO: Mover restante das regras de negócio para domain
    override var state by mutableStateOf(SearchFormState())
    override val validationEventChannel = Channel<ValidationEvent>()
    override val validationEvents = validationEventChannel.receiveAsFlow()

    override val message: StateFlow<String?>
        get() = setMessage
    private val setMessage: MutableStateFlow<String?> = MutableStateFlow(null)

    override val resultTakePokemons: StateFlow<List<PokemonEntity>?>
        get() = setResultTakePokemons
    private var setResultTakePokemons: MutableStateFlow<List<PokemonEntity>?> =
        MutableStateFlow(null)

    override val resultTakeTypes: StateFlow<List<TypeEntity>?>
        get() = setResultTakeTypes
    private var setResultTakeTypes: MutableStateFlow<List<TypeEntity>?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            if (resultTakePokemons.value.isNullOrEmpty()) getListPokemons()
            else successTakePokemons(resultTakePokemons.value!!)
            if (resultTakeTypes.value.isNullOrEmpty()) getListType()
            else successTakeTypes(resultTakeTypes.value!!)
        }
    }

    override fun successTakePokemons(result: List<PokemonEntity>) {
        setResultTakePokemons.value = result
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    override fun successTakeTypes(result: List<TypeEntity>) {
        setResultTakeTypes.value = result
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    override fun successTakeRandomPoke(result: Int?) {
        state = state.copy(randomId = result.toString(), randomSelected = true)
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    override fun failure(message: Throwable?) {
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

    override fun getListOnlyByType() {
        val idType =
            resultTakeTypes.value!!.filter { type -> type.name.equals(state.searchDropDown) }
        viewModelScope.launch {
            if (idType[0].id != null) {
                val result = getListByType.execute(idType[0].id.toString())
                result.handleResult(::successTakePokemons, ::failure)
            }
        }
    }

    override fun getListByTypeAndName() {
        val idType =
            resultTakeTypes.value!!.filter { type -> type.name.equals(state.searchDropDown) }
        viewModelScope.launch {
            if (idType[0].id != null) {
                val result = getListWithNameAndTypeUseCase.execute(
                    listOf(
                        SearchEntity(
                            id = idType[0].id.toString(),
                            name = state.searchInput.uppercase()
                        )
                    )
                )
                result.handleResult(::successTakePokemons, ::failure)
            }
        }

    }

    override fun getRandomPokemon() {
        viewModelScope.launch {
            val result = getRandomPokeUseCase.execute(null)
            result.handleResult(::successTakeRandomPoke, ::failure)
        }
    }

    override fun searchItem() {
        when {
            !resultTakePokemons.value.isNullOrEmpty() -> {
                when {
                    state.searchInput.isNotEmpty() && state.searchDropDown.isNotEmpty() -> getListByTypeAndName()
                    state.searchInput.isEmpty() && state.searchDropDown.isNotEmpty() -> getListOnlyByType()
                    state.searchInput.isNotEmpty() && state.searchDropDown.isEmpty() -> {
                        val (filterResult, rest) = resultTakePokemons.value!!.partition { pokemon ->
                            pokemon.name.startsWith(
                                state.searchInput.uppercase(),
                                ignoreCase = true
                            )
                        }
                        successTakePokemons(filterResult + rest)
                    }

                    else -> getListPokemons()
                }
            }

            else -> getListPokemons()
        }
    }

    override fun cleanSearchItem() {
        state = state.copy(reset = true)
        getListPokemons()
    }


    private fun change(
        searchInput: String? = null,
        searchDropDown: String? = null,
        reset: Boolean = false,
    ) {
        when {
            searchInput != null -> state = state.copy(searchInput = searchInput)
            searchDropDown != null -> state = state.copy(searchDropDown = searchDropDown)
            reset -> state = state.copy(reset = !reset, searchInput = "")
        }
    }

    override fun onEvent(event: SearchFormEvent) {
        when (event) {
            is SearchFormEvent.SearchInputChanged -> change(searchInput = event.name)
            is SearchFormEvent.SearchDropDownMenuChanged -> change(searchDropDown = event.idType)
            is SearchFormEvent.SearchButton -> searchItem()
            is SearchFormEvent.ResetChanged -> change(reset = event.reset)
            is SearchFormEvent.CleanSearchButton -> cleanSearchItem()
            is SearchFormEvent.RandomButton -> getRandomPokemon()
        }
    }
}
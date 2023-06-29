package egsys.pokedex.ui.screens.appArea.home

import androidx.lifecycle.viewModelScope
import egsys.domain.entities.PokemonEntity
import egsys.domain.usecase.home.GetListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val getListUseCase: GetListUseCase
) : HomeViewModel() {
    override val message: StateFlow<String?>
        get() = setMessage
    private val setMessage: MutableStateFlow<String?> = MutableStateFlow(null)

    override val result: StateFlow<List<PokemonEntity>?>
        get() = setResult
    private var setResult: MutableStateFlow<List<PokemonEntity>?> = MutableStateFlow(null)

    fun success(result: List<PokemonEntity>) {
        setResult.value = result
    }

    fun failure(message: Throwable?) {
        setMessage.value = message?.message
    }

    init {
        submitData()
    }

    override fun submitData() {
        viewModelScope.launch {
            val result = getListUseCase.execute(null)
            result.handleResult(::success, ::failure)
        }

    }
}
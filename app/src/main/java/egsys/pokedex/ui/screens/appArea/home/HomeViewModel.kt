package egsys.pokedex.ui.screens.appArea.home

import androidx.lifecycle.ViewModel
import egsys.domain.entities.PokemonEntity
import kotlinx.coroutines.flow.StateFlow

abstract class HomeViewModel: ViewModel() {
    abstract val message : StateFlow<String?>
    abstract val result : StateFlow<List<PokemonEntity>?>
    abstract fun submitData()
}
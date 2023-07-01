package egsys.pokedex.ui.screens.appArea.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import egsys.pokedex.ui.base.ValidationEvent
import egsys.pokedex.ui.screens.appArea.home.componente.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(navController: NavController) {
    val viewModel: HomeViewModel = getViewModel()
    val listPokemonsState = remember { mutableStateOf(viewModel.resultTakePokemons.value) }
    val listTypeState = remember { mutableStateOf(viewModel.resultTakeTypes.value) }
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is ValidationEvent.Success -> {
                    listPokemonsState.value = viewModel.resultTakePokemons.value
                    listTypeState.value = viewModel.resultTakeTypes.value
                }

                is ValidationEvent.Failed -> {
                    //TODO: Ação em caso de falha
                }
            }
        }
    }
    Screen(listPokemons = listPokemonsState.value, listType = listTypeState.value)
}
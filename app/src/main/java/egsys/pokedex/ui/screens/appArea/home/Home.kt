package egsys.pokedex.ui.screens.appArea.home

import android.widget.Toast
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
                    if (viewModel.state.randomSelected) {
                        navController.navigate("details/${viewModel.state.randomId}")
                        viewModel.state.randomSelected = false
                    }
                    Toast.makeText(context, viewModel.message.value, Toast.LENGTH_SHORT).show()
                }

                is ValidationEvent.Failed -> {
                    Toast.makeText(context, viewModel.message.value, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    Screen(
        listPokemons = listPokemonsState.value,
        listType = listTypeState.value,
        viewModel = viewModel,
        navController = navController
    )
}
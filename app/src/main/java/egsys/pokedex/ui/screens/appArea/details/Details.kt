package egsys.pokedex.ui.screens.appArea.details

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import egsys.pokedex.ui.base.ValidationEvent
import egsys.pokedex.ui.screens.appArea.details.componente.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun Details(navController: NavController, param: String?) {
    val viewModel: DetailViewModel = getViewModel()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.fetchData(param)
    }
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is ValidationEvent.Success -> {
                    //TODO: Estrutura basica para uso posterior
                }
                is ValidationEvent.Failed -> {
                    //TODO: Ação em caso de falha

                }
            }
        }
    }
    Screen(
        navController = navController,
        image = viewModel.state.image,
        name = viewModel.state.name,
        height = viewModel.state.height,
        weight = viewModel.state.weight,
        type = viewModel.state.type,
        load = viewModel.state.load
    )
}


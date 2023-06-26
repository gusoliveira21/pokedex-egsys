package egsys.pokedex.ui.screens.apresentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import egsys.pokedex.R
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.pokeball0),
            contentDescription = "Imagem pets",
            modifier = Modifier.align(Alignment.Center)
        )
    }
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("mainContent")
    }
}
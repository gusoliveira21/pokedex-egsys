package egsys.pokedex.ui.screens.appArea.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import egsys.domain.entities.PokemonEntity
import egsys.pokedex.R
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(navController: NavController) {
    val viewModel: HomeViewModel = getViewModel()
    var value = viewModel.result.value

    Box(modifier = Modifier.fillMaxSize()) {
        Tela(value)
        Button(onClick = { viewModel.submitData() }) {
            Text("Click para atualizar a lista!")
        }
    }
}


@Composable
fun Tela(lista: List<PokemonEntity>?) {
    val isLoading = lista.isNullOrEmpty()

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(lista!!.size) { item ->
                    // Exibir um Text simples para cada elemento da lista
                    Text(text = lista[item].name)
                }
            }
        }
    }
}


@Composable
fun ItemPokemon(
    image: Painter = painterResource(id = R.drawable.pokeball1),
    name: String = "Name",
    imageBackground: Color = Color.Red,
    nameBackground: Color = Color.Blue,
    onClick: () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        val full = maxWidth
        Column(modifier = Modifier.clickable { onClick }
        ) {
            Row {
                Card(
                    modifier = Modifier.size(width = full, height = full / 1.4f),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .background(imageBackground)
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = image,
                            contentDescription = "Imagem Pokemon",
                            modifier = Modifier
                                .size(full / 1.3f)
                                .padding(8.dp)
                                .align(Alignment.TopCenter)
                        )
                    }
                }
            }
            Row {
                Card(modifier = Modifier.size(width = full, height = full / 4f)) {
                    Box(
                        modifier = Modifier
                            .background(nameBackground)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = name.uppercase(),
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
package egsys.pokedex.ui.screens.appArea.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import egsys.domain.entities.PokemonEntity
import egsys.pokedex.ui.base.ValidationEvent
import egsys.pokedex.ui.componente.setImage
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(navController: NavController) {
    val viewModel: HomeViewModel = getViewModel()
    val listaState = remember { mutableStateOf<List<PokemonEntity>?>(viewModel.result.value) }
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is ValidationEvent.Success -> {
                    listaState.value = viewModel.result.value
                    Toast.makeText(context, "Sucesso!", Toast.LENGTH_LONG).show()
                }

                is ValidationEvent.Failed -> {
                    Toast.makeText(context, "Falha!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Screen(listaState.value)
            Row(content = {
                Button(onClick = { viewModel.submitData() }) {
                    Text("Click para atualizar a lista!")
                }
            })
        }
    }
}

@Composable
fun Screen(lista: List<PokemonEntity>?) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (lista == null) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(lista.size) { index ->
                    ItemPokemon(
                        name = lista[index].name,
                        image = lista[index].image,
                        onClick = {
                            Log.e("testar", "${lista[index].name} foi selecionado!")
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun ItemPokemon(
    name: String = "Name",
    image: String,
    imageBackground: Color = MaterialTheme.colorScheme.onBackground,
    nameBackground: Color = MaterialTheme.colorScheme.background,
    onClick: () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(8.dp)
            .background(nameBackground)
    ) {
        val full = maxWidth
        Card(modifier = Modifier
            .fillMaxSize(),
            content = {
                Column {
                    Row {
                        Card(
                            modifier = Modifier
                                .size(width = full, height = full / 1.4f),
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
                                setImage(
                                    image = image,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .fillMaxSize(0.9f)
                                        .align(Alignment.Center)
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
            })
    }
}
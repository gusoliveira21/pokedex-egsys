package egsys.pokedex.ui.screens.appArea.home.componente

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity
import egsys.pokedex.ui.componente.Button2
import egsys.pokedex.ui.componente.DropdownListType
import egsys.pokedex.ui.componente.InputText
import egsys.pokedex.ui.componente.ItemPokemon

@Composable
fun Screen(listPokemons: List<PokemonEntity>?, listType: List<TypeEntity>?) {
    var selectedIndex = remember { mutableStateOf(-1) }

    Box(modifier = Modifier.fillMaxSize()) {
        if (listPokemons == null) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    InputText(
                        textTop = "Search",
                        textValue = "",
                        textHint = "eg: Bulbasaur",
                        textError = listOf(),
                        onEvent = {}
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                { if (!listType.isNullOrEmpty()) DropdownListType(list = listType) }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button2(
                        text = "Search",
                        submit = { /*TODO*/ },
                        enableButton = true
                    )
                }
                Row {
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        items(listPokemons.size) { index ->
                            ItemPokemon(
                                name = listPokemons[index].name,
                                image = listPokemons[index].image,
                                onClick = {
                                    Log.e("testar", "${listPokemons[index].name} foi selecionado!")
                                }
                            )
                        }
                    }
                }
            }


        }
    }
}
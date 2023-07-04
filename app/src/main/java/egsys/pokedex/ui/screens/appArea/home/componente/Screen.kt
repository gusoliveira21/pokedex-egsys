package egsys.pokedex.ui.screens.appArea.home.componente

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import egsys.domain.entities.PokemonEntity
import egsys.domain.entities.TypeEntity
import egsys.pokedex.ui.componente.Button2
import egsys.pokedex.ui.componente.DropdownListType
import egsys.pokedex.ui.componente.InputText
import egsys.pokedex.ui.componente.ItemPokemon
import egsys.pokedex.ui.screens.appArea.home.HomeViewModel
import egsys.pokedex.ui.screens.appArea.home.SearchFormEvent

@Composable
fun Screen(
    listPokemons: List<PokemonEntity>?,
    listType: List<TypeEntity>?,
    viewModel: HomeViewModel,
    navController: NavController
) {
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
                        textValue = viewModel.state.searchInput,
                        textHint = "eg: Bulbasaur",
                        textError = listOf(),
                        onEvent = { it: String ->
                            viewModel.onEvent(
                                SearchFormEvent.SearchInputChanged(
                                    it
                                )
                            )
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                {
                    if (!listType.isNullOrEmpty())
                        DropdownListType(
                            list = listType,
                            onEvent = { it: String ->
                                viewModel.onEvent(
                                    SearchFormEvent.SearchDropDownMenuChanged(
                                        it
                                    )
                                )
                            },
                            resetAction = viewModel.state.reset,
                            onEventReset = { it: Boolean ->
                                viewModel.onEvent(
                                    SearchFormEvent.ResetChanged(it)
                                )
                            }
                        )

                }
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.36f)
                        ) {
                            Button2(
                                text = "Search",
                                submit = { viewModel.onEvent(SearchFormEvent.SearchButton) },
                                enableButton = true,
                                modifier = Modifier.align(Start)
                            )
                        }

                        Column(modifier = Modifier.align(CenterVertically)) {
                            Button2(
                                text = "Clean Filter",
                                submit = { viewModel.onEvent(SearchFormEvent.CleanSearchButton) },
                                enableButton = true,
                            )

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Button2(
                                text = "Random",
                                submit = { viewModel.onEvent(SearchFormEvent.RandomButton) },
                                enableButton = true,
                                modifier = Modifier.align(End)
                            )
                        }

                    }
                }


                Row {
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        items(listPokemons.size) { index ->
                            ItemPokemon(
                                name = listPokemons[index].name,
                                image = listPokemons[index].image,
                                onClick = {
                                    navController.navigate("details/${listPokemons[index].id}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

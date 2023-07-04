package egsys.pokedex.ui.screens.appArea.details.componente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import egsys.pokedex.ui.componente.setImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(
    navController: NavController,
    image: String?,
    name: String?,
    weight: Int?,
    height: Int?,
    type: List<String>?,
    load: Boolean
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (load) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Detalhes") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                            }
                        }
                    )
                },
                content = { padding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(60.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        setImage(
                            image = image,
                            modifier = Modifier
                                .size(300.dp)
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            text = name?.uppercase() ?: "unknown".uppercase(),
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier
                                .padding(8.dp)
                                .align(Alignment.CenterHorizontally)
                        )


                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(CircleShape), shape = RoundedCornerShape(percent = 40)
                        ) {
                            Text(
                                text = "Weight: " + weight.toString() + "(grams)",
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                                fontFamily = FontFamily.SansSerif,
                                modifier = Modifier
                                    .padding(18.dp)
                                    .align(Alignment.Start)
                            )
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(CircleShape), shape = RoundedCornerShape(percent = 40)
                        ) {
                            Text(
                                text = "Height: " + height.toString() + "(decimeter)",
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                                fontFamily = FontFamily.SansSerif,
                                modifier = Modifier
                                    .padding(18.dp)
                                    .align(Alignment.Start)
                            )
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(CircleShape), shape = RoundedCornerShape(percent = 40)
                        ) {
                            Text(
                                text = "TYPE",
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                fontFamily = FontFamily.SansSerif,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                        Row() {
                            type?.forEach {
                                Card(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                                    Text(
                                        text = it,
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                                    )
                                }

                            }
                        }


                    }
                }
            )
        }
    }
}

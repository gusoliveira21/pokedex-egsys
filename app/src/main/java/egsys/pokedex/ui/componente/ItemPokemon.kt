package egsys.pokedex.ui.componente

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            .clickable(onClick = onClick)
    ) {
        val full = maxWidth
        Card(modifier = Modifier
            .fillMaxSize()
            .shadow(10.dp),
            content = {
                Column {
                    Row(modifier = Modifier.background(nameBackground)) {
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
            })
    }
}
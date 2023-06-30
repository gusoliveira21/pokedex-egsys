package egsys.pokedex.ui.componente

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun setImage(
    contentDescription: String? = null,
    image: String,
    modifier: Modifier = Modifier
        .clip(CircleShape)
        .fillMaxSize()
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(CircleShape)
            .fillMaxSize(),
        contentDescription = contentDescription
    )
}
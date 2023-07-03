package egsys.pokedex.ui.componente

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Button2(
    submit: () -> Unit,
    enableButton: Boolean,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    text: String = "Button",
    buttonColor: ButtonColors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
    textColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Button(
        onClick = { submit() },
        enabled = enableButton,
        modifier = modifier,
        border = border,
        colors = buttonColor
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color = textColor
        )
    }
}
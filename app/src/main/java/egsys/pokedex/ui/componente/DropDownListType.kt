package egsys.pokedex.ui.componente

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import egsys.domain.entities.TypeEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownListType(
    list: List<TypeEntity>,
    onEvent: (String) -> Unit,
    nameShow: String = "Type selected",
    resetAction: Boolean = false,
    onEventReset: (Boolean) -> Unit,
) {
    val nameList = list.map { it.name }
    var selectedText by remember { mutableStateOf(nameShow) }
    var expanded by remember { mutableStateOf(false) }
    var reset by remember { mutableStateOf(false) }

    if (resetAction) {
        selectedText = nameShow
        expanded = false
        onEventReset(true)
        reset = false
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                nameList.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                            onEvent(item)
                        }
                    )
                }
            }
        }
    }
}

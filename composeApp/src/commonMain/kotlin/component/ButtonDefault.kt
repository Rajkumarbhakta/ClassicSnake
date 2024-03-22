package component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonDefault(
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(0.85f),
        shape = RoundedCornerShape(50.dp),
        onClick = { onClick.invoke() },
    ) {
        Text(text = text)
    }
}

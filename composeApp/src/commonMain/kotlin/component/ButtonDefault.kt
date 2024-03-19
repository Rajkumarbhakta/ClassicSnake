import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import theme.DarkGreen
import theme.LightGreen

@Composable
fun ButtonDefault(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
    ) {
        Text(text = text)
    }
}

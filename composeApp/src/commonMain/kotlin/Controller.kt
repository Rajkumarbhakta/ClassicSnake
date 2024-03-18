import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val buttonSize = Modifier.size(64.dp)

@Composable
fun Controller(onDirectionChange: (Int) -> Unit) {

    val currentDirection = remember { mutableStateOf(SnakeDirection.Right) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {

        ControllerButton(icon = Icons.Default.KeyboardArrowUp) {
            if (currentDirection.value != SnakeDirection.Down) {
                onDirectionChange.invoke(SnakeDirection.Up)
                currentDirection.value = SnakeDirection.Up
            }
        }

        Row {
            ControllerButton(icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft) {
                if (currentDirection.value != SnakeDirection.Right) {
                    onDirectionChange.invoke(SnakeDirection.Left)
                    currentDirection.value = SnakeDirection.Left
                }
            }
            Spacer(modifier = buttonSize)
            ControllerButton(icon = Icons.AutoMirrored.Filled.KeyboardArrowRight) {
                if (currentDirection.value != SnakeDirection.Left) {
                    onDirectionChange.invoke(SnakeDirection.Right)
                    currentDirection.value = SnakeDirection.Right
                }
            }
        }
        ControllerButton(icon = Icons.Default.KeyboardArrowDown) {
            if (currentDirection.value != SnakeDirection.Up) {
                onDirectionChange.invoke(SnakeDirection.Down)
                currentDirection.value = SnakeDirection.Down
            }
        }
    }
}


@Composable
fun ControllerButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
    Button(onClick = { onClick.invoke() }, modifier = buttonSize) {
        Icon(imageVector = icon, contentDescription = "")
    }
}

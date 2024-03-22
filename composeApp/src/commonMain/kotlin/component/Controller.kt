package component

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
import constants.SnakeDirection

val buttonSize = Modifier.size(64.dp)

@Composable
fun Controller(onDirectionChange: (Int) -> Unit) {

    val currentDirection = remember { mutableStateOf(SnakeDirection.RIGHT) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {

        ControllerButton(icon = Icons.Default.KeyboardArrowUp) {
            if (currentDirection.value != SnakeDirection.DOWN) {
                onDirectionChange.invoke(SnakeDirection.UP)
                currentDirection.value = SnakeDirection.UP
            }
        }

        Row {
            ControllerButton(icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft) {
                if (currentDirection.value != SnakeDirection.RIGHT) {
                    onDirectionChange.invoke(SnakeDirection.LEFT)
                    currentDirection.value = SnakeDirection.LEFT
                }
            }
            Spacer(modifier = buttonSize)
            ControllerButton(icon = Icons.AutoMirrored.Filled.KeyboardArrowRight) {
                if (currentDirection.value != SnakeDirection.LEFT) {
                    onDirectionChange.invoke(SnakeDirection.RIGHT)
                    currentDirection.value = SnakeDirection.RIGHT
                }
            }
        }
        ControllerButton(icon = Icons.Default.KeyboardArrowDown) {
            if (currentDirection.value != SnakeDirection.UP) {
                onDirectionChange.invoke(SnakeDirection.DOWN)
                currentDirection.value = SnakeDirection.DOWN
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

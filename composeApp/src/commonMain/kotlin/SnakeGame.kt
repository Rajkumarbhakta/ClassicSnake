import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@Composable
fun SnakeGame(game: GameEngine) {
    val state = game.state.collectAsState(null)

    if (getPlatform().name.contains("Java")) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                state.value?.let {
                    Board(it)
                }
            }
            Controller() {
                when (it) {
                    SnakeDirection.Up -> game.move = Pair(0, -1)
                    SnakeDirection.Left -> game.move = Pair(-1, 0)
                    SnakeDirection.Right -> game.move = Pair(1, 0)
                    SnakeDirection.Down -> game.move = Pair(0, 1)
                }
            }

        }
    } else {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.weight(1f)) {
                state.value?.let {
                    Board(it)
                }
            }
            Controller() {
                when (it) {
                    SnakeDirection.Up -> game.move = Pair(0, -1)
                    SnakeDirection.Left -> game.move = Pair(-1, 0)
                    SnakeDirection.Right -> game.move = Pair(1, 0)
                    SnakeDirection.Down -> game.move = Pair(0, 1)
                }
            }
        }
    }


}
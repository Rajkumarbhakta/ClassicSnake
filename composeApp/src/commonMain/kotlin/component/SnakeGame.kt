import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import theme.LightGreen

@Composable
fun SnakeGame(game: GameEngine) {

    BoxWithConstraints {
        if (maxWidth > 600.dp) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                ScreenContent(game, Modifier.weight(1f))
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ScreenContent(game, Modifier.weight(1f))
            }
        }

    }


}

@Composable
fun ScreenContent(
    game: GameEngine,
    modifier: Modifier
) {
    val state = game.state.collectAsState(null)
    Box(modifier = modifier) {
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
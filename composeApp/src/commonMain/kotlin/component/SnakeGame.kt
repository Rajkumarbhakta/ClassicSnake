package component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import constants.SnakeDirection
import data.GameEngine


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
            SnakeDirection.UP -> game.move = Pair(0, -1)
            SnakeDirection.LEFT -> game.move = Pair(-1, 0)
            SnakeDirection.RIGHT -> game.move = Pair(1, 0)
            SnakeDirection.DOWN -> game.move = Pair(0, 1)
        }
    }
}
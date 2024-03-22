package component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.GameEngine
import data.GameState
import theme.RedPantone

@Composable
fun Board(state: GameState) {

    BoxWithConstraints(modifier = Modifier.padding(16.dp)) {
        val tileSize = maxWidth / GameEngine.BOARD_SIZE
        Box(
            Modifier
                .size(maxWidth)
                .border(2.dp, MaterialTheme.colors.primary, shape = RoundedCornerShape(8.dp))
        )
        Box(
            Modifier
                .offset(x = tileSize * state.food.first, y = tileSize * state.food.second)
                .size(tileSize)
                .background(
                    RedPantone, CircleShape
                )
        )
        state.snake.forEach {
            Box(
                modifier = Modifier
                    .offset(x = tileSize * it.first, y = tileSize * it.second)
                    .size(tileSize)
                    .background(
                        MaterialTheme.colors.onSurface, RoundedCornerShape(4.dp)
                    )
            )
        }
    }


}
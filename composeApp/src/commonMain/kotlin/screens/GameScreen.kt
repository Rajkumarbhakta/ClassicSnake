package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import component.AppBar
import component.SnakeGame
import viewmodel.GameScreenViewModel

data class GameScreen(
    val speed: Long,
    val mode: GameMode
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel: GameScreenViewModel =
            rememberScreenModel { GameScreenViewModel(speed, mode) }
        val gameEngine = viewModel.gameEngine
        val score = remember {
            viewModel.score
        }
        val isGameEnded = remember {
            viewModel.isGameEnded
        }

        Scaffold(topBar = {
            AppBar("") {
                navigator!!.pop()
            }
        }) {
            Column(
                modifier = Modifier.fillMaxSize().padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Score : ${score.value}")
                SnakeGame(gameEngine)
            }

            if (isGameEnded.value) {
                navigator!!.replace(GameEndedScreen(score.value))
            }

        }
    }
}
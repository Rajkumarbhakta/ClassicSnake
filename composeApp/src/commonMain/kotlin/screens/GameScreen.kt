import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import component.AppBar
import viewmodel.GameScreenViewModel

class GameScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel: GameScreenViewModel = rememberScreenModel { GameScreenViewModel() }
        val gameEngine = viewModel.gameEngine
        val score = remember {
            viewModel.score
        }
        Scaffold(topBar = {
            AppBar(""){
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
        }
    }
}
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import viewmodel.GameScreenViewModel

class GameScreen : Screen {
    @Composable
    override fun Content() {
     val viewModel:GameScreenViewModel = rememberScreenModel { GameScreenViewModel() }
       val gameEngine = viewModel.gameEngine
        SnakeGame(gameEngine)
    }
}
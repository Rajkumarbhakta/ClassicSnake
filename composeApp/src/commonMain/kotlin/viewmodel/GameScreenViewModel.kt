package viewmodel

import GameEngine
import androidx.compose.runtime.*
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.*
import screens.GameMode

class GameScreenViewModel(
    private val speed: Long,
    private val mode: GameMode
) : ScreenModel {

    private val _score = mutableIntStateOf(0)
    val score: State<Int> = _score

    private val _isGameEnded = mutableStateOf(false)

    val isGameEnded: State<Boolean> = _isGameEnded

    val gameEngine = GameEngine(scope = CoroutineScope(Dispatchers.IO),
        gameMode = mode,
        speed = speed,
        onFoodEaten = {
            calculateScore()
        }, onGameEnded = {
            onGameEnded()
        })

    private fun calculateScore() {
        _score.intValue++
    }

    private fun onGameEnded() {
//        _score.intValue = 0
        _isGameEnded.value = true
    }


}
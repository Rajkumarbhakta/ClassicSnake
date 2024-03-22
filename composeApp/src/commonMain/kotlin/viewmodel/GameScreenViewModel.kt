package viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import data.GameEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import screens.GameMode

class GameScreenViewModel(
    speed: Long,
    mode: GameMode
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
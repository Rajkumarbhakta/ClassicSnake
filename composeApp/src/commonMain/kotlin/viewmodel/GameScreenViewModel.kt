package viewmodel

import GameEngine
import androidx.compose.runtime.*
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.*

class GameScreenViewModel : ScreenModel {

    private val _score = mutableIntStateOf(0)
    
    val score:State<Int> = _score

    val gameEngine = GameEngine(scope = CoroutineScope(Dispatchers.IO),
        onFoodEaten = {
            calculateScore()
        }, onGameEnded = {

        })
    
    
    private fun calculateScore(){
        _score.value++
    }




}
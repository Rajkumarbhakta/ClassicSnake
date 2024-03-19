package viewmodel

import GameEngine
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class GameScreenViewModel :ScreenModel{
    
    
    val gameEngine = GameEngine(scope = CoroutineScope(Dispatchers.IO), onFoodEaten = {
        
    }, onGameEnded = {
        
    })
    
    
    
}
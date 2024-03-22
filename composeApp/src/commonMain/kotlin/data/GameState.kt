package data

data class GameState(
    val food: Pair<Int, Int>,
    val snake: List<Pair<Int, Int>>,
    val currentDirection: Int
)
package screens

import ButtonDefault
import GameScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import classicsnake.composeapp.generated.resources.Res
import classicsnake.composeapp.generated.resources.snake
import data.SnakeSpeed
import getPlatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import theme.DarkGreen
import theme.LightGreen

class HomeScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val isDialogVisible = rememberSaveable {
            mutableStateOf(false)
        }
        val gameMode = rememberSaveable {
            mutableStateOf(GameMode.Normal)
        }

        val sliderPosition = rememberSaveable {
            mutableFloatStateOf(3f)
        }



        Scaffold {
            Column(
                modifier = Modifier.fillMaxSize().padding(it),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(vertical = 16.dp, horizontal = 16.dp)
                        .border(
                            border = BorderStroke(3.dp, color = MaterialTheme.colors.primary),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    if (getPlatform().name.contains("Android")) {
                        Text(
                            "Snake",
                            fontSize = 30.sp
                        )
                    } else {
                        Text(
                            "Snake",
                            fontSize = 30.sp,
                            fontFamily = FontFamily(Font(Res.font.snake))
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    ButtonDefault(text = "New Game") {
//                        navigator!!.push(GameScreen())
                        isDialogVisible.value = true
                    }

//                    ButtonDefault(text = "Settings") {
//                        isDialogVisible.value = true
//                        //navigator!!.push(SettingsScreen())
//                    }

                    ButtonDefault(text = "About") {
                        navigator!!.push(AboutScreen())
                    }


                    if (isDialogVisible.value) {
                        GameSettingDialog(
                            isDialogVisible = isDialogVisible,
                            gameMode = gameMode,
                            sliderPosition = sliderPosition
                        ) {
                            try {
                                val speed = sliderPosition.floatValue.toInt()
                                when (speed) {
                                    1 -> {
                                        navigator!!.push(GameScreen(SnakeSpeed.ONE, gameMode.value))
                                    }

                                    2 -> {
                                        navigator!!.push(GameScreen(SnakeSpeed.TWO, gameMode.value))
                                    }

                                    3 -> {
                                        navigator!!.push(GameScreen(SnakeSpeed.THREE, gameMode.value))
                                    }

                                    4 -> {
                                        navigator!!.push(GameScreen(SnakeSpeed.FOUR, gameMode.value))
                                    }

                                    5 -> {
                                        navigator!!.push(GameScreen(SnakeSpeed.FIVE, gameMode.value))
                                    }
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                                navigator!!.push(GameScreen(200L, GameMode.Normal))
                            }
                        }
                    }


                }
            }
        }

    }


    @Composable
    private fun GameSettingDialog(
        isDialogVisible: MutableState<Boolean> = mutableStateOf(false),
        gameMode: MutableState<GameMode> = mutableStateOf(GameMode.Normal),
        sliderPosition: MutableFloatState = mutableFloatStateOf(3f),
        startGame: () -> Unit
    ) {
        Dialog(onDismissRequest = {

        }) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(8.dp))
            ) {
                Text(
                    "Settings",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    "Game Mode",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                )

                GameModeSwitcher(gameMode)

                Text(
                    "Snake Speed",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                )

                Slider(
                    value = sliderPosition.value, onValueChange = {
                        sliderPosition.value = it
                    },
                    valueRange = 1f..5f, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
                    Button(
                        modifier = Modifier.weight(1f).padding(end = 4.dp),
                        shape = RoundedCornerShape(50.dp),
                        onClick = {
                            isDialogVisible.value = false
                        }) {
                        Text("Cancel")
                    }
                    Button(
                        modifier = Modifier.weight(1f).padding(end = 4.dp),
                        shape = RoundedCornerShape(50.dp),
                        onClick = {
                            isDialogVisible.value = false
                            startGame.invoke()
                        }) {
                        Text("Start")
                    }
                }
            }
        }

    }


    @Composable
    fun GameModeSwitcher(
        gameMode: MutableState<GameMode> = mutableStateOf(GameMode.Normal)
    ) {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)
                .background(color = MaterialTheme.colors.secondary, shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                GameMode.Normal.name,
                modifier = Modifier.weight(1f)
                    .background(
                        color = if (gameMode.value == GameMode.Normal) LightGreen else DarkGreen,
                        shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                    )
                    .clickable {
                        gameMode.value = GameMode.Normal
                    }
                    .padding(8.dp),
                color = Color.White
            )
            Text(
                GameMode.Box.name,
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (gameMode.value == GameMode.Box) LightGreen else DarkGreen,
                        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                    )
                    .clickable {
                        gameMode.value = GameMode.Box
                    }
                    .padding(8.dp),
                color = Color.White
            )
        }
    }

}

enum class GameMode {
    Normal,
    Box
}



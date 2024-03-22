package screens

import ButtonDefault
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import classicsnake.composeapp.generated.resources.Res
import classicsnake.composeapp.generated.resources.snake
import component.AppBar
import getPlatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

data class GameEndedScreen(val score: Int) : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current

        Scaffold() {
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
                            "Game Ended",
                            fontSize = 30.sp
                        )
                    } else {
                        Text(
                            "Game Ended",
                            fontSize = 30.sp,
                            fontFamily = FontFamily(Font(Res.font.snake))
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("Your Score", fontSize = 20.sp)
                    Text("$score", fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(16.dp))

                    ButtonDefault(text = "OK") {
                        navigator!!.pop()
                    }
                }
            }
        }


    }

}
package screens

import ButtonDefault
import GameScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import classicsnake.composeapp.generated.resources.Res
import classicsnake.composeapp.generated.resources.lato
import classicsnake.composeapp.generated.resources.snake
import getPlatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import theme.AppTheme
import theme.DarkGreen
import theme.LightGreen

class HomeScreen : Screen {

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Scaffold {
            Column(
                modifier = Modifier.fillMaxSize().padding(it),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(vertical = 16.dp, horizontal = 16.dp)
                        .border(border = BorderStroke(3.dp, color = DarkGreen), shape = RoundedCornerShape(8.dp)),
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
                        navigator!!.push(GameScreen())
                    }

                    ButtonDefault(text = "Settings") {
                        navigator!!.push(SettingsScreen())
                    }

                    ButtonDefault(text = "About") {
                        navigator!!.push(AboutScreen())
                    }
                }
                //border(border = BorderStroke(3.dp, color = DarkGreen), shape = RoundedCornerShape(8.dp))


            }
        }

    }
}

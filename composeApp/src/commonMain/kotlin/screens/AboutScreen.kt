package screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import component.AppBar

class AboutScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Scaffold(
            topBar = {
                AppBar("About") {
                    navigator!!.pop()
                }
            }
        ) {

            Box(modifier = Modifier.fillMaxSize().padding(it)) {
                Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 8.dp)) {

                    Text("About Screen")


                }
            }
        }

    }

}
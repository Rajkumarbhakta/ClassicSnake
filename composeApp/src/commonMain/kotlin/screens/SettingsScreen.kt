package screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import component.AppBar

class SettingsScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current

        Scaffold(topBar = {
            AppBar("Settings") {
                navigator!!.pop()
            }
        }) {


        }


    }


}
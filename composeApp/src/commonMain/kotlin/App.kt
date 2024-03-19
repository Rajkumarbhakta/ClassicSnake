import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import classicsnake.composeapp.generated.resources.Res
import classicsnake.composeapp.generated.resources.compose_multiplatform
import screens.HomeScreen
import theme.AppTheme

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    AppTheme(
        
    ) {
        Navigator(HomeScreen()) {
            SlideTransition(it)
        }
    }
}
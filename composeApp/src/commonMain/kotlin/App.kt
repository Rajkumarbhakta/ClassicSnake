import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.HomeScreen
import theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme() {
        Surface {
            Navigator(HomeScreen()) {
                SlideTransition(it)
            }
        }
    }
}
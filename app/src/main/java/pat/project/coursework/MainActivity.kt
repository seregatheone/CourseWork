package pat.project.coursework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import pat.project.coursework.ui.themes.AppResources
import pat.project.coursework.ui.themes.CourseWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            CourseWorkTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppResources.colors.BackgroundWhite)
                        .systemBarsPadding()
                ) {
                    Navigation()
                }
            }
        }
    }
}

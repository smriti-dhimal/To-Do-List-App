package np.com.dhimalsmriti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var screen by remember { mutableStateOf("splash") }

            when (screen) {
                "splash" -> SplashScreen { screen = "home" }
                "home" -> HomeScreen(
                    openAdd = { screen = "add" },
                    openEdit = { screen = "edit" },
                    openCompleted = { screen = "completed" }
                )
                "add" -> AddTaskScreen { screen = "home" }
            }
        }
    }
}
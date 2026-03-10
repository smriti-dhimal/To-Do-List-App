package np.com.dhimalsmriti

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinish: () -> Unit) {

    // Wait 2 seconds, then navigate to next screen
    LaunchedEffect(true) {
        delay(2000)
        onFinish()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // App Logo using built-in icon
            Image(
                imageVector = Icons.Default.List,
                contentDescription = "App Logo",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // App Name
            Text("To-Do List App", fontSize = 28.sp)

            Spacer(modifier = Modifier.height(10.dp))

            // Loading Text
            Text("Loading...")
        }
    }
}
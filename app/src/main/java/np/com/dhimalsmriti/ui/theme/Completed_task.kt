package np.com.dhimalsmriti

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompletedTasksScreen(onBack: () -> Unit) {

    // Sample completed tasks for UI
    var completedTasks by remember {
        mutableStateOf(
            listOf("Submit assignment", "Pay bills", "Study Android")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Completed Tasks", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(completedTasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = task,
                        modifier = Modifier.weight(1f)
                    )

                    // Delete permanently button
                    TextButton(onClick = {
                        completedTasks = completedTasks.filter { it != task }
                    }) {
                        Text("Delete")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Back button
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}
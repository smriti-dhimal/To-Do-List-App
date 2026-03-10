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

// Simple Task model
data class Task(val title: String, val completed: Boolean)

@Composable
fun HomeScreen(
    openAdd: () -> Unit,
    openEdit: () -> Unit,
    openCompleted: () -> Unit
) {

    // Sample tasks for UI
    var tasks by remember {
        mutableStateOf(
            listOf(
                Task("Buy groceries", false),
                Task("Study Android", true),
                Task("Finish assignment", false)
            )
        )
    }

    Scaffold(
        floatingActionButton = {
            // + Button to add task
            FloatingActionButton(onClick = openAdd) {
                Text("+", fontSize = 24.sp)
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("To-Do List", fontSize = 26.sp)

            Spacer(modifier = Modifier.height(10.dp))

            // Task list
            LazyColumn {
                items(tasks) { task ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Status: Completed / Pending
                        Text(
                            text = if (task.completed) "✅" else "⏳",
                            modifier = Modifier.width(30.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        // Task title
                        Text(
                            text = task.title,
                            modifier = Modifier.weight(1f)
                        )

                        // Edit button
                        TextButton(onClick = openEdit) {
                            Text("Edit")
                        }

                        // Delete button
                        TextButton(onClick = {
                            tasks = tasks.filter { it.title != task.title }
                        }) {
                            Text("Delete")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Button to view completed tasks
            Button(onClick = openCompleted) {
                Text("View Completed Tasks")
            }
        }
    }
}
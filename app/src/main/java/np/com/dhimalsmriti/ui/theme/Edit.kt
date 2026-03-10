package np.com.dhimalsmriti

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment

@Composable
fun EditTaskScreen(onUpdate: () -> Unit) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var completed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Edit Task", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(20.dp))

        // Task title field
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Task Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Task description field
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Completed checkbox
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = completed,
                onCheckedChange = { completed = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Mark as Completed")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Update button
        Button(
            onClick = onUpdate,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update Task")
        }
    }
}
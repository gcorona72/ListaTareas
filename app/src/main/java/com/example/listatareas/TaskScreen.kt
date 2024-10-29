// TaskScreen.kt
package com.example.todolist.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.listatareas.TaskViewModel
import com.example.listatareas.Task


@Composable
fun TaskScreen(taskViewModel: TaskViewModel) {
    val allTasks = taskViewModel.tasks
    var taskDescription by remember { mutableStateOf("") }
    var showDoneTasks by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = taskDescription,
            onValueChange = { taskDescription = it },
            label = { Text("Nueva tarea") }
        )
        Button(onClick = {
            if (taskDescription.isNotEmpty()) {
                taskViewModel.addTask(taskDescription)
                taskDescription = ""
            }
        }) {
            Text("Añadir tarea")
        }

        Row {
            Button(onClick = { showDoneTasks = false }) {
                Text("Pendientes")
            }
            Button(onClick = { showDoneTasks = true }) {
                Text("Hechas")
            }
        }

        LazyColumn {
            items(taskViewModel.getFilteredTasks(showDoneTasks)) { task ->
                TaskItem(task, taskViewModel)
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, taskViewModel: TaskViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { taskViewModel.toggleTaskDone(task) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = task.description,
            style = if (task.isDone) TextStyle(textDecoration = TextDecoration.LineThrough) else TextStyle()
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { taskViewModel.deleteTask(task) }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}

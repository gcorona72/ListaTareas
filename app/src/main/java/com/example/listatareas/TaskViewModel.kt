package com.example.listatareas

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<Task>()
    val tasks: List<Task> get() = _tasks

    fun addTask(description: String) {
        _tasks.add(Task(id = _tasks.size + 1, description = description))
    }

    fun deleteTask(task: Task) {
        _tasks.remove(task)
    }

    fun toggleTaskDone(task: Task) {
        task.isDone = !task.isDone
    }

    fun getFilteredTasks(showDone: Boolean): List<Task> {
        return _tasks.filter { it.isDone == showDone }
    }
}

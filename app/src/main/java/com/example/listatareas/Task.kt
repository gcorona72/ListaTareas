package com.example.listatareas

data class Task(
    val id: Int,
    val description: String,
    var isDone: Boolean = false
)
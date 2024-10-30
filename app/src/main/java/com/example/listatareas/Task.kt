package com.example.listatareas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey val id: Int,
    val description: String,
    var isDone: Boolean = false
)
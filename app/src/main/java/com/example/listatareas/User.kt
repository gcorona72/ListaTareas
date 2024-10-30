package com.example.listatareas

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "users")
@TypeConverters(TaskListConverter::class)
data class User(
    @PrimaryKey val username: String,
    val password: String,
    val tasks: MutableList<Task> = mutableListOf()
)
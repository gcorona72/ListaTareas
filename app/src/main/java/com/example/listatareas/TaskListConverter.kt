package com.example.listatareas

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskListConverter {
    @TypeConverter
    fun fromTaskList(tasks: MutableList<Task>): String {
        val gson = Gson()
        val type = object : TypeToken<MutableList<Task>>() {}.type
        return gson.toJson(tasks, type)
    }

    @TypeConverter
    fun toTaskList(tasksString: String): MutableList<Task> {
        val gson = Gson()
        val type = object : TypeToken<MutableList<Task>>() {}.type
        return gson.fromJson(tasksString, type)
    }
}
package com.example.listatareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.todolist.ui.TaskScreen
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar la base de datos
        db = AppDatabase.getDatabase(applicationContext, lifecycleScope)

        setContent {
            LoginScreen(
                onLogin = { username: String, password: String, showMessage ->
                    lifecycleScope.launch {
                        val user = db.userDao().getUser(username)
                        if (user != null && user.password == password) {
                            showMessage("Inicio de sesión exitoso")
                            // Navegar al menú principal
                            setContent {
                                TaskScreen(taskViewModel = TaskViewModel())
                            }
                        } else {
                            showMessage("Usuario no encontrado o contraseña incorrecta")
                        }
                    }
                }
            )
        }
    }
}
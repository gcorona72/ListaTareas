# Lista de Tareas

Este proyecto es una aplicación de lista de tareas desarrollada en Kotlin utilizando Android Jetpack Compose y Room para la gestión de la base de datos.

## Características

- Inicio de sesión con validación de usuario.
- Gestión de tareas (añadir, eliminar, marcar como hechas).
- Persistencia de datos utilizando Room.

## Requisitos

- Android Studio
- Kotlin 1.8
- Gradle

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/lista-tareas.git
    ```
2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con Gradle.

## Estructura del Proyecto

- `MainActivity.kt`: La actividad principal que muestra la pantalla de tareas.
- `LoginActivity.kt`: La actividad de inicio de sesión.
- `LoginScreen.kt`: Composable para la pantalla de inicio de sesión.
- `TaskScreen.kt`: Composable para la pantalla de tareas.
- `TaskViewModel.kt`: ViewModel para gestionar el estado de las tareas.
- `AppDatabase.kt`: Configuración de la base de datos Room.
- `User.kt`: Entidad de usuario.
- `Task.kt`: Entidad de tarea.
- `UserDao.kt`: DAO para acceder a los datos de usuario.
- `TaskListConverter.kt`: Conversor para listas de tareas.

## Uso

1. Inicia la aplicación.
2. Ingresa con el usuario `1` y la contraseña `1`.
3. Accede al menú principal y gestiona tus tareas.

## Dependencias

- AndroidX Core
- AndroidX Lifecycle
- AndroidX Activity Compose
- AndroidX Compose UI
- AndroidX Material3
- AndroidX Room
- Gson

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

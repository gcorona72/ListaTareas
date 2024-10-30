package com.example.listatareas

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUser(username: String): User?

    @Delete
    suspend fun deleteUser(user: User)
}
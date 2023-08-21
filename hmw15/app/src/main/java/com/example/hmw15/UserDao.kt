package com.example.hmw15

import androidx.room.*
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update
import java.util.concurrent.Flow


@Dao
interface UserDao {

    @Query("SELECT*FROM user") //что-то не подтягивает селект и фром
    fun getAll(): Flow<List<User>>

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)
}
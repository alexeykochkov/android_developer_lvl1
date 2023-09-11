package com.example.hmw15

import androidx.room.*
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TableDao {

    @Query("SELECT * FROM  text_table")  //что-то не подтягивает селект и фром
    fun getAll(): Flow<List<Table>>

    @Query( "SELECT * FROM text_table WHERE :text == text_table.word" )
    suspend fun getItem(text:String): Table?

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(table: Table)

    @Delete
    suspend fun delete(table: Table)

    @Update
    suspend fun update(table: Table)

    @Query ("DELETE FROM text_table")
    suspend fun deleteAll()
}
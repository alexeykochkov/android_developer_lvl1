package com.example.hmw15

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Table::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun tableDao():TableDao
}
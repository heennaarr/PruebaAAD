package com.example.pruebaaad.core

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pruebaaad.data.db.Converters
import com.example.pruebaaad.data.db.UserDao
import com.example.pruebaaad.data.db.UserEntity

@Database(entities = [UserEntity::class], version = 1 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao() : UserDao
}
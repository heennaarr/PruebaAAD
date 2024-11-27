package com.example.pruebaaad.core

import android.content.Context
import androidx.room.Room

class DataBaseProvider {
    fun providerDb(context: Context): AppDataBase{
        val db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"
        ).fallbackToDestructiveMigration()
            return db.build()
    }
}
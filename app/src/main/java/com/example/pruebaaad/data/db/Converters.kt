package com.example.pruebaaad.data.db

import androidx.room.TypeConverter
import com.example.pruebaaad.domain.Surname
import com.google.gson.Gson

class Converters {
    val gson = Gson()
    @TypeConverter
    fun fromEntity(surname: String) : Surname{
        return gson.fromJson(surname,Surname::class.java)
    }
    @TypeConverter
    fun toEntity(surname: Surname) : String{
        return gson.toJson(surname)
    }



}
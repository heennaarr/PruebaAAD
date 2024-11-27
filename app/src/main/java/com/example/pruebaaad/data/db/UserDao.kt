package com.example.pruebaaad.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaaad.domain.User

@Dao
interface UserDao {
    @Query("SELECT * FROM $USER_TABLE")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM $USER_TABLE WHERE  $USER_ID = :id")
    fun getById(id:String) : UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user:UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("DELETE FROM $USER_TABLE")
    fun deleteAll()
}
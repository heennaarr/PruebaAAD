package com.example.pruebaaad.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebaaad.domain.Surname

const val USER_TABLE = "user"
const val USER_ID = "id"

@Entity(tableName = USER_TABLE)
class UserEntity(
    @PrimaryKey @ColumnInfo(name = USER_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: Surname

)
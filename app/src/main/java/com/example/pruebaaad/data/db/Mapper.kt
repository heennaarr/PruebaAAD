package com.example.pruebaaad.data.db

import com.example.pruebaaad.domain.User


fun UserEntity.toModel(): User =
    User(this.id,this.name,this.surname)

fun User.toEntity() : UserEntity =
    UserEntity(this.id,this.name,this.surname)
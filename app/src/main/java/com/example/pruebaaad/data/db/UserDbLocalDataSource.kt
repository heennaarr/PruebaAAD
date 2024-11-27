package com.example.pruebaaad.data.db

import com.example.pruebaaad.domain.User


class UserDbLocalDataSource(
    private val dao:UserDao
){
    fun getAll() : List<User>{
        return dao.getAll().map {
            it.toModel()
        }

    }
    fun getById(id:String) : User {
        return dao.getById(id).toModel()
    }
    fun insert(user:User){
        return dao.insert(user.toEntity())
    }
    fun insertAll(user : List<User>){
        return dao.insertAll(*user.map {
            it.toEntity()
        }.toTypedArray())
    }
    fun delete(user:User){
        return dao.delete(user.toEntity())
    }
    fun deleteAll(){
        return dao.deleteAll()
    }
}
package com.example.pruebaaad.data

import android.content.Context
import com.example.pruebaaad.R
import com.example.pruebaaad.domain.User
import com.google.gson.Gson

class UserXmlLocalDataSource(context: Context) {
    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.app_name), Context.MODE_PRIVATE
    )
    private val gson = Gson()

    fun saveAll(users: List<User>) {
        val edit = sharedPref.edit()
        users.forEach{
            edit.putString(it.id, gson.toJson(it))
        }
        edit.apply()
        }
    fun saveUser(user:User){
       sharedPref.edit().putString(user.id , gson.toJson(user)).apply()
    }

    fun getAll() : List<User>{
       val list = mutableListOf<User>()
        val user = sharedPref.all

        user.forEach{
            list.add(gson.fromJson(it.value as String , User::class.java))
        }
        return list
    }

    fun getUser(id:String) :User{
        return gson.fromJson(sharedPref.getString(id, ""),User::class.java)
    }

    fun removeAll(){
        sharedPref.edit().clear().apply()
    }
    fun removeItem(id:String){
        sharedPref.edit().remove(id).apply()
    }


}
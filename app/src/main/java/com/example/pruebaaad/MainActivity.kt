package com.example.pruebaaad

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pruebaaad.core.DataBaseProvider
import com.example.pruebaaad.data.UserXmlLocalDataSource
import com.example.pruebaaad.data.db.UserDbLocalDataSource
import com.example.pruebaaad.domain.Compuesto
import com.example.pruebaaad.domain.Surname
import com.example.pruebaaad.domain.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeShared()
        executeRoom()
    }
    private fun executeRoom(){
        val user1 = User(
            id = "1",
            name = "John",
            surname = Surname(
                first = "Doe",
                compuesto = Compuesto(
                    first = "Smith",
                    second = "Johnson"
                )
            )
        )

        val user2 = User(
            id = "2",
            name = "Jane",
            surname = Surname(
                first = "Brown",
                compuesto = Compuesto(
                    first = "Williams",
                    second = "Davis"
                )
            )
        )
        val users = listOf(user1, user2)
        val room = UserDbLocalDataSource(
            DataBaseProvider().providerDb(this).userDao()
        )
        GlobalScope.launch {
            room.insertAll(users)
        }


    }




    private fun executeShared(){
        val user1 = User(
            id = "1",
            name = "John",
            surname = Surname(
                first = "Doe",
                compuesto = Compuesto(
                    first = "Smith",
                    second = "Johnson"
                )
            )
        )

        val user2 = User(
            id = "2",
            name = "Jane",
            surname = Surname(
                first = "Brown",
                compuesto = Compuesto(
                    first = "Williams",
                    second = "Davis"
                )
            )
        )

        // Lista de usuarios
        val users = listOf(user1, user2)
        val xml = UserXmlLocalDataSource(this)
        xml.saveAll(users)
    }

}
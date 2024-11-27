package com.example.pruebaaad.domain

data class User (
    val id: String,
    val name: String,
    val surname: Surname
)
data class Surname(
    val first: String,
    val compuesto: Compuesto
)
data class Compuesto(
    val first: String,
    val second: String
)
package com.example.debtsapp.models.responses

data class UserResponse(
    val id: Int,
    val name: String?,

    val debt: Int
)
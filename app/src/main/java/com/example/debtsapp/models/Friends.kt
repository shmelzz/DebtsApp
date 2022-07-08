package com.example.debtsapp.models

data class Friends(
    val id: Int,
    val requestedByyId: Int,
    val requestedBy: User,
    val friendId: Int,
    val friend: Int
)
package com.example.debtsapp.models

data class Activity(
    val id: Int,
    var name: String,
    var ownerID: Int,
    var owner: User,
    var sum: Int
)
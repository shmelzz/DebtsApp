package com.example.debtsapp.models

data class ActivityMember(
    val id: Int,
    val activity: Activity,
    val user: User,
    val userId: Int,
    val activityId: Int,
    var activityAcceptedByUser: Boolean
)
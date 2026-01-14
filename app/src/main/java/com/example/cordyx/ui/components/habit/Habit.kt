package com.example.cordyx.ui.components.habit

import java.util.UUID

data class Habit(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String = "",
    val xpReward: Int,
    val completed: Boolean = false,
    val streak: Int = 0
)

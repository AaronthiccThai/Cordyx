package com.example.cordyx.ui.components.habit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.UUID

class HabitViewModel {
    var habits by mutableStateOf(listOf<Habit>())
        private set

    fun addHabit(title: String, xp:  Int) {
        habits = habits + Habit(
            title = title,
            xpReward = xp
        )

    }

    fun deleteHabit(id: String) {
        habits = habits.filter{it.id != id}
    }

    fun completeHabit(id: String) {
        habits = habits.map {
            if (it.id == id) {
                it.copy(completed = true, streak = it.streak + 1)
            } else it
        }
    }

    fun resetHabits() {
        habits = habits.map {
            it.copy(completed = false, streak = 0)
        }
    }

}

//val id: String = UUID.randomUUID().toString(),
//val title: String,
//val description: String,
//val xpReward: Int,
//val completed: Boolean = false,
//val streak: Int = 0
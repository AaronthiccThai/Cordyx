package com.example.cordyx.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.cordyx.ui.components.habit.HabitCard
import com.example.cordyx.ui.components.habit.HabitViewModel


@Composable
fun HabitScreen(viewModel: HabitViewModel) {
    val habits = viewModel.habits

    LazyColumn() {
        items(habits, key = {it.id}) {
            habit -> HabitCard(
                habit = habit,
                onCheckChanged = {
                    if (!habit.completed) {
                        viewModel.completeHabit(habit.id)}
                }
            )
        }
    }
}

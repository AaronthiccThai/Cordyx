package com.example.cordyx.ui.components.schedule

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cordyx.ui.components.schedule.ScheduleBlock

class ScheduleViewModel : ViewModel() {

    var selectedDay = mutableStateOf("Monday")
        private set

    // ✅ Mutable map + mutable lists
    private val _schedules = mutableStateMapOf(
        "Monday" to mutableStateListOf(
            ScheduleBlock(9, "Study"),
            ScheduleBlock(14, "Gym")
        ),
        "Tuesday" to mutableStateListOf(),
        "Wednesday" to mutableStateListOf(),
        "Thursday" to mutableStateListOf(),
        "Friday" to mutableStateListOf(),
        "Saturday" to mutableStateListOf(),
        "Sunday" to mutableStateListOf()
    )

    val schedules: Map<String, List<ScheduleBlock>> = _schedules

    fun updateSelectedDay(day: String) {
        selectedDay.value = day
    }

    fun scheduleForSelectedDay(): List<ScheduleBlock> {
        return _schedules[selectedDay.value] ?: emptyList()
    }

    fun addEvent(block: ScheduleBlock) {
        val dayList = _schedules[selectedDay.value] ?: return
        dayList.removeAll { it.hour == block.hour }
        dayList.add(block)
    }
}

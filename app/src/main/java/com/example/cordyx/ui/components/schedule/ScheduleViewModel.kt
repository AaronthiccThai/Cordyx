package com.example.cordyx.ui.components.schedule

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cordyx.ui.components.data.ScheduleDatabase
import com.example.cordyx.ui.components.data.ScheduleRepository
import com.example.cordyx.ui.components.schedule.ScheduleBlock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

//https://developer.android.com/kotlin/flow
//
class ScheduleViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = ScheduleDatabase
        .getDatabase(application)
        .scheduleDao()

    private val repository = ScheduleRepository(dao)

    private val _selectedDay = MutableStateFlow("Monday")
    val selectedDay: StateFlow<String> = _selectedDay

    private val _scheduleForDay =
        MutableStateFlow<List<ScheduleBlock>>(emptyList())
    val scheduleForDay: StateFlow<List<ScheduleBlock>> = _scheduleForDay

    init {
        observeSelectedDay()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeSelectedDay() {
        viewModelScope.launch {
            _selectedDay
                .flatMapLatest { repository.scheduleForDay(it) }
                .collect { blocks ->
                    _scheduleForDay.value = blocks
                }
        }
    }

    fun selectDay(day: String) {
        _selectedDay.value = day
    }

    fun addEvent(block: ScheduleBlock) {
        viewModelScope.launch {
            repository.insert(_selectedDay.value, block)
        }
    }
}
//class ScheduleViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val dao = ScheduleDatabase.getDatabase(application).scheduleDao()
//
//    private val repository = ScheduleRepository(dao)
//
//    private val _selectedDay = MutableStateFlow("Monday")
//    val selectedDay: StateFlow<String> = _selectedDay
//
//
//    private val _schedules = mutableStateMapOf(
//        "Monday" to mutableStateListOf(
//            ScheduleBlock(9, "Study"),
//            ScheduleBlock(14, "Gym")
//        ),
//        "Tuesday" to mutableStateListOf(),
//        "Wednesday" to mutableStateListOf(),
//        "Thursday" to mutableStateListOf(),
//        "Friday" to mutableStateListOf(),
//        "Saturday" to mutableStateListOf(),
//        "Sunday" to mutableStateListOf()
//    )
//
//    val schedules: Map<String, List<ScheduleBlock>> = _schedules
//
//    fun updateSelectedDay(day: String) {
//        selectedDay.value = day
//    }
//
//    fun scheduleForSelectedDay(): List<ScheduleBlock> {
//        return _schedules[selectedDay.value] ?: emptyList()
//    }
//
//    fun addEvent(block: ScheduleBlock) {
//        val dayList = _schedules[selectedDay.value] ?: return
//        dayList.removeAll { it.hour == block.hour }
//        dayList.add(block)
//    }
//}
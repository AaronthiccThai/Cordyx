package com.example.cordyx.ui.components.schedule

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cordyx.ui.components.schedule.ScheduleViewModel
import com.example.cordyx.ui.components.settings.SettingsViewModel

@Composable
fun ScheduleScreen(
    scheduleViewModel: ScheduleViewModel = viewModel(),
    settingViewModel: SettingsViewModel = viewModel()
) {

    val days = listOf(
        "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday", "Sunday"
    )

    val hours = (0..23).toList()
    val selectedDay by scheduleViewModel.selectedDay.collectAsState()
    val schedule by scheduleViewModel.scheduleForDay.collectAsState()

    Column() {
        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 12.dp)
        ) {
            items(days) { day ->
                DayBlock(
                    day = day,
                    selected = selectedDay == day,
                    onClick = { scheduleViewModel.selectDay(day) }
                )
            }

        }

        HorizontalDivider()
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(hours) { hour ->
                val label = if (settingViewModel.is24hr) {
                    "${hour.toString().padStart(2, '0')}:00"
                } else {
                    formatTo12Hour(hour)
                }

                val block = schedule.find { it.hour == hour }

                TimeBlock(
                    hour = label,
                    title = block?.title ?: "Free",
                    onClick = { Log.d("TAG", "CLICKING TIME BLOCK")}
                )
            }
        }
    }


}

fun formatTo12Hour(hour: Int): String {
    require(hour in 0..23)

    return when (hour) {
        0 -> "12 AM"
        12 -> "12 PM"
        in 1..11 -> "$hour AM"
        else -> "${hour - 12} PM"
    }
}


package com.example.cordyx.ui.components.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cordyx.ui.components.schedule.ScheduleBlock

@Entity(tableName = "schedule")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val day: String,
    val hour: Int,
    val title: String
)

fun ScheduleEntity.toScheduleBlock(): ScheduleBlock {
    return ScheduleBlock(hour = hour, title = title)
}

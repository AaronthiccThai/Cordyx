package com.example.cordyx.ui.components.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val day: String,
    val hour: Int,
    val title: String
)

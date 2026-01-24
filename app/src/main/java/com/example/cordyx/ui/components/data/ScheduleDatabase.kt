package com.example.cordyx.ui.components.data

import androidx.room.Database

@Database(
    entities = [ScheduleEntity::class],
    version = 1
)
abstract class ScheduleDatabase() {
}
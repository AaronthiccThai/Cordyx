package com.example.cordyx.ui.components.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule WHERE day = :day ORDER BY hour ASC")
    fun getScheduleForDay(day: String): Flow<List<ScheduleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(block: ScheduleEntity)

    @Query("DELETE FROM schedule WHERE id = :id")
    suspend fun delete(id: Int)
}
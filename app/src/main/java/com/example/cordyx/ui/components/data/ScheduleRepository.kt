package com.example.cordyx.ui.components.data

import com.example.cordyx.ui.components.schedule.ScheduleBlock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//ScheduleScreen ->
//ScheduleViewModel ->
//ScheduleRepository ->
//ScheduleDao (Room) ->
//ScheduleDatabase ->

class ScheduleRepository(private val dao: ScheduleDao) {
    fun scheduleForDay(day: String): Flow<List<ScheduleBlock>> {
        return dao.getScheduleForDay(day).map { entities ->
            entities.map { it.toScheduleBlock() }
        }
    }

    suspend fun insert(day: String, block: ScheduleBlock) {
        dao.insert(ScheduleEntity(day = day, hour = block.hour, title = block.title))
    }

    suspend fun delete(id: Int) {
        dao.delete(id)
    }
}

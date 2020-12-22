package com.lakshmi.mini_project.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StateDao {
    @Insert
    suspend fun insertState(state: States)
    @Query("Select * From State")
    fun getAllStates(): LiveData<List<States>>
}
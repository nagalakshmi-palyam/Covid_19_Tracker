package com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DetailsDao {
    @Insert
    suspend fun insertDetails(todayDetails: Details)
    @Query("Select * From Details")
    fun getAllDetails(): LiveData<List<Details>>

}
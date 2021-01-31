package com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Details::class], version = 1, exportSchema = false)
abstract class DetailsDatabase:RoomDatabase() {
    abstract val todayDetailsDao: DetailsDao

    companion object {

        private var INSTANCE: DetailsDatabase? = null

        fun getInstance(context: Context): DetailsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, DetailsDatabase::class.java, "Details_DB").
                        allowMainThreadQueries().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
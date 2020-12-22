package com.lakshmi.mini_project.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [States::class], version = 1, exportSchema = false)
abstract class StateDatabase: RoomDatabase() {
    abstract val stateDao: StateDao

    companion object {

        private var INSTANCE: StateDatabase? = null

        fun getInstance(context: Context): StateDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, StateDatabase::class.java, "States_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
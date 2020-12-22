package com.lakshmi.mini_project.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "State")
data class States(
    @PrimaryKey(autoGenerate = true)
    var stateId: Int = 0,

    @ColumnInfo(name = "stateName")
    val stateName: String,
    @ColumnInfo(name = "state")
    val state: String
)
package com.lakshmi.mini_project.RoomDatabaseForStatisticsFragment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Details")
data class Details (
    @PrimaryKey(autoGenerate = true)
    var stateId: Int = 0,
    @ColumnInfo(name = "affected")
    val affected: String,
    @ColumnInfo(name = "recovered")
    val recovered: String,
    @ColumnInfo(name = "deaths")
    val deaths: String,
    @ColumnInfo(name = "serious")
    val serious: String,
    @ColumnInfo(name="active")
    val active:String
)
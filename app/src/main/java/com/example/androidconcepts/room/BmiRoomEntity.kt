package com.example.androidconcepts.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidconcepts.model.BmiInfo

@Entity(tableName = "BmiRoomEntity")
data class BmiRoomEntity(
    val info: BmiInfo,
    @PrimaryKey
    val request : String
)
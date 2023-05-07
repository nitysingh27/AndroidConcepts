package com.example.androidconcepts.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BmiRoomEntity")
data class RoomEntity(
    val info: String,

    @PrimaryKey
    val request : String
)
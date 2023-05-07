package com.example.androidconcepts.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidconcepts.model.BmiInfo

@Entity(tableName = "BmiRoomEntity")
data class BmiRoomEntity(
    val info: String,

    @PrimaryKey
    val request : String
)
package com.example.androidconcepts.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BmiDao {

    @Insert
    suspend fun insertBmiRequestResponse(bmiRoomEntity: BmiRoomEntity)

    @Query("SELECT * FROM BmiRoomEntity WHERE request = :request ")
    suspend fun getBmiFromRequest(request :String) : List<BmiRoomEntity>
}
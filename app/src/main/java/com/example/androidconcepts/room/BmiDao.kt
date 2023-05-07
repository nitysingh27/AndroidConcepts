package com.example.androidconcepts.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidconcepts.model.BmiRoomEntity

@Dao
interface BmiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBmiRequestResponse(bmiRoomEntity: BmiRoomEntity)

    @Query("SELECT * FROM BmiRoomEntity WHERE request = :request ")
    suspend fun getBmiFromRequest(request :String) : List<BmiRoomEntity>
}
package com.example.androidconcepts.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidconcepts.model.RoomEntity

@Dao
interface BmiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBmiRequestResponse(roomEntity: RoomEntity)

    @Query("SELECT * FROM BmiRoomEntity WHERE request = :request ")
    suspend fun getBmiFromRequest(request :String) : List<RoomEntity>
}
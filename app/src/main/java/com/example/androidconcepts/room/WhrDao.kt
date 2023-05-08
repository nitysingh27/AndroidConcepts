package com.example.androidconcepts.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidconcepts.model.RoomEntity
import okhttp3.Request

@Dao
interface WhrDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWhrRequestResponse(roomEntity: RoomEntity)

    @Query("SELECT * FROM BmiRoomEntity WHERE request = :request")
    suspend fun getWhrFromRequest(request: String):List<RoomEntity>
}
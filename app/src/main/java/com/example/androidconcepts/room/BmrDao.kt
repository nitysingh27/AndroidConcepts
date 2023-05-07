package com.example.androidconcepts.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidconcepts.model.RoomEntity
@Dao
interface BmrDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBmrRequestResponse(bmrRoomEntity: RoomEntity)

    @Query("SELECT * FROM BmiRoomEntity WHERE request = :request ")
    suspend fun getBmrFromRequest(request :String) : List<RoomEntity>
}
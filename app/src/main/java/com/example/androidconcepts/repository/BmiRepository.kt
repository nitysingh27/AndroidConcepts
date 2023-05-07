package com.example.androidconcepts.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.androidconcepts.model.BmiResponseEntity
import com.example.androidconcepts.retrofit.RetrofitApiCall
import com.example.androidconcepts.room.BmiDao
import com.example.androidconcepts.room.BmiRoomEntity
import javax.inject.Inject

class BmiRepository @Inject constructor(
    var retrofit: RetrofitApiCall,
    var room: BmiDao
) {
    suspend fun bmicalc(weight: String, height: String): BmiResponseEntity {
        //Check room to see  if response exists
        val requestString = "$weight $height"
        var responseList = room.getBmiFromRequest(requestString)
        for (i in responseList){
            Log.d(TAG, "responseList Element : $i")
        }
        val v = retrofit.getBmi(weight = weight, height = height)
        room.insertBmiRequestResponse(BmiRoomEntity(v.info,requestString))
        Log.d(TAG, "value of v: $v")
        return v
    }
}
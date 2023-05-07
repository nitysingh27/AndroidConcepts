package com.example.androidconcepts.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.androidconcepts.model.BmiInfo
import com.example.androidconcepts.model.BmiResponseEntity
import com.example.androidconcepts.model.BmiRoomEntity
import com.example.androidconcepts.retrofit.RetrofitApiCall
import com.example.androidconcepts.room.BmiDao
import com.google.gson.Gson
import javax.inject.Inject

class BmiRepository @Inject constructor(
    var retrofit: RetrofitApiCall,
    var room: BmiDao
) {
    suspend fun bmicalc(weight: String, height: String): BmiResponseEntity {
        //Check room to see  if response exists
        val requestString = "$weight $height"
        var responseList = room.getBmiFromRequest(requestString)
        if (responseList.isEmpty()) {
            val v = retrofit.getBmi(weight = weight, height = height)
            room.insertBmiRequestResponse(BmiRoomEntity(Gson().toJson(v.info), requestString))
            Log.d(TAG, "value from api call : $v")
            return v
        } else {
            val v = responseList.get(0).info
            val infoObject = Gson().fromJson(v, BmiInfo::class.java)
            Log.d(TAG, "value from cache call : $infoObject")
            return BmiResponseEntity(
                info = infoObject
            )
        }

    }
}
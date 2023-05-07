package com.example.androidconcepts.repository

import android.content.ContentValues
import android.util.Log
import com.example.androidconcepts.model.BmiInfo
import com.example.androidconcepts.model.BmrInfo
import com.example.androidconcepts.model.RoomEntity
import com.example.androidconcepts.retrofit.RetrofitApiCall
import com.example.androidconcepts.room.BmrDao
import com.google.gson.Gson
import javax.inject.Inject

class BmrRepository @Inject constructor(
    var bmrRetrofit: RetrofitApiCall,
    var bmrRoom : BmrDao
) {

    suspend fun bmrcalc(weight: String, height: String, age: String, gender: String): BmrInfo {
        var requestString = "$weight $height $age $gender"
        var responseList = bmrRoom.getBmrFromRequest(requestString)
        if (responseList.isEmpty()){
            var v =bmrRetrofit.getBmr(weight, height, age, gender).info
            bmrRoom.insertBmrRequestResponse(RoomEntity(Gson().toJson(v), requestString))
            Log.d(ContentValues.TAG, "value from api call : $v")
            return v
        }
        else{
            var v = responseList.get(0).info
            val infoObject = Gson().fromJson(v, BmrInfo::class.java)
            Log.d(ContentValues.TAG, "value from cache call : $infoObject")
            return infoObject
        }

    }
}
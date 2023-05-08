package com.example.androidconcepts.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.androidconcepts.model.RoomEntity
import com.example.androidconcepts.model.WhrInfo
import com.example.androidconcepts.retrofit.RetrofitApiCall
import com.example.androidconcepts.room.WhrDao
import com.google.gson.Gson
import javax.inject.Inject

class WhrRepository @Inject constructor(
    private var retrofitApiCall: RetrofitApiCall,
    private var whrDao: WhrDao
) {
    suspend fun calcwhr(waist:String,hip:String,gender:String):WhrInfo{
        var requestString = "{$waist} {$hip} {$gender}"
        var responseList = whrDao.getWhrFromRequest(requestString)
        if (responseList.isEmpty())
        {
            var v = retrofitApiCall.getWhr(waist,hip, gender).whrInfo
            whrDao.insertWhrRequestResponse(RoomEntity(Gson().toJson(v),requestString))
            Log.d(TAG, "getting from api: $v ")
            return v
        }
        else{
            var v= responseList.get(0).info
            var whrInfoObject = Gson().fromJson(v,WhrInfo::class.java)
            Log.d(TAG, "getting from cache: $whrInfoObject ")
            return whrInfoObject
        }

    }
}
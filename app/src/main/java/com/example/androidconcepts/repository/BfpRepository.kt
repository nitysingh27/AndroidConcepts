package com.example.androidconcepts.repository

import android.util.Log
import com.example.androidconcepts.model.BfpInfo
import com.example.androidconcepts.model.BmrInfo
import com.example.androidconcepts.model.RoomEntity
import com.example.androidconcepts.retrofit.RetrofitApiCall
import com.example.androidconcepts.room.BfpDao
import com.google.gson.Gson
import javax.inject.Inject

class BfpRepository @Inject constructor(
    private var  bfpRetrofit : RetrofitApiCall,
    private var bfpRoom : BfpDao
) {
     suspend fun bfpcalc(weight:String,height:String,age:String,gender:String) : BfpInfo {
         var requestString = "$weight $height $age $gender"
         var responseList = bfpRoom.getBfpFromRequest(requestString)
         if (responseList.isEmpty()){
             var v = bfpRetrofit.getBfp(weight,height,age,gender).info
             Log.d("TAG", "bfpcalc: $v")
             bfpRoom.insertBfpRequestResponse(RoomEntity(Gson().toJson(v), requestString))
             return v

         }
         else
         {
             var v = responseList.get(0).info
             var bfpObject = Gson().fromJson(v, BfpInfo::class.java)
             return bfpObject
         }



    }
}
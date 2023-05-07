package com.example.androidconcepts.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.androidconcepts.model.BmiResponse
import com.example.androidconcepts.retrofit.BmiRetrofit
import javax.inject.Inject

class BmiRepository @Inject constructor(
    var retrofit : BmiRetrofit
) {

    suspend fun bmicalc(weight:String, height : String) : BmiResponse {
        val v = retrofit.getBmi(weight = weight, height = height)
        Log.d(TAG, "value of v: $v")
        return BmiResponse(0.0," ")
    }
}
package com.example.androidconcepts.repository

import com.example.androidconcepts.model.BmrInfo
import com.example.androidconcepts.retrofit.RetrofitApiCall
import javax.inject.Inject

class BmrRepository @Inject constructor(
    var bmrRetrofit: RetrofitApiCall
) {

    suspend fun bmrcalc(weight: String, height: String, age: String, gender: String): BmrInfo {
        return bmrRetrofit.getBmr(weight, height, age, gender).info
    }
}
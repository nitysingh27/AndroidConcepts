package com.example.androidconcepts.repository

import com.example.androidconcepts.model.BmrResponseEntity
import com.example.androidconcepts.retrofit.RetrofitApiCall
import retrofit2.Retrofit
import javax.inject.Inject

class BmrRepository @Inject constructor(
    var bmrRetrofit: RetrofitApiCall
) {

    suspend fun bmrcalc(weight: String, height: String, age: String, gender: String): BmrResponseEntity {
        return bmrRetrofit.getBmr(weight,height,age,gender)
    }
}
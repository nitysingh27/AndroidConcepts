package com.example.androidconcepts.repository

import com.example.androidconcepts.model.BfpInfo
import com.example.androidconcepts.retrofit.RetrofitApiCall
import javax.inject.Inject

class BfpRepository @Inject constructor(
    private var  bfpRetrofit : RetrofitApiCall
) {
     suspend fun bfpcalc(weight:String,height:String,age:String,gender:String) : BfpInfo {

         var v = bfpRetrofit.getBfp(weight,height,age,gender).info
         return v

    }
}
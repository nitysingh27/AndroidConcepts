package com.example.androidconcepts.retrofit

import com.example.androidconcepts.model.BfpResposneEntity
import com.example.androidconcepts.model.BmiResponseEntity
import com.example.androidconcepts.model.BmrInfo
import com.example.androidconcepts.model.BmrResposneEntity
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitApiCall {
    @Headers(
        "X-RapidAPI-Key:c1013262aamsh706a8f67b1e6ad3p1b4a90jsn936f9e42cf9a",
        "X-RapidAPI-Host:mega-fitness-calculator1.p.rapidapi.com"
    )
    @GET("/bmi")
    suspend fun getBmi(
        @Query("weight") weight: String,
        @Query("height") height: String
    ): BmiResponseEntity

    @Headers(
        "X-RapidAPI-Key:c1013262aamsh706a8f67b1e6ad3p1b4a90jsn936f9e42cf9a",
        "X-RapidAPI-Host:mega-fitness-calculator1.p.rapidapi.com"
    )

    @GET("/bmr")
    suspend fun getBmr(
        @Query("weight") weight: String,
        @Query("height") height: String,
        @Query("age") age: String,
        @Query("gender") gender: String
    ): BmrResposneEntity

    @Headers(
        "X-RapidAPI-Key:c1013262aamsh706a8f67b1e6ad3p1b4a90jsn936f9e42cf9a",
        "X-RapidAPI-Host:mega-fitness-calculator1.p.rapidapi.com"
    )
    @GET("/bfp")
    suspend fun getBfp(
        @Query("weight") weight: String,
        @Query("height") height: String,
        @Query("age") age: String,
        @Query("gender") gender: String
    ): BfpResposneEntity

}
package com.example.androidconcepts.retrofit

import com.example.androidconcepts.model.BmiResponseEntity
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BmiRetrofit {
    @Headers(
        "X-RapidAPI-Key:c1013262aamsh706a8f67b1e6ad3p1b4a90jsn936f9e42cf9a",
        "X-RapidAPI-Host:mega-fitness-calculator1.p.rapidapi.com"
    )
    @GET("/bmi")
    suspend fun getBmi(@Query("weight") weight: String, @Query("height") height: String): BmiResponseEntity

    /* @GET("movie/{movie_id}")
     fun getMovieDetails(@Path("movie_id") id: Int): Call<MovieDetailsResponse>*/

}
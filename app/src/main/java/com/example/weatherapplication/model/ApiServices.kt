package com.example.weatherapplication.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("search.json")
    fun search_location(
        @Query("key") apiKey: String,
        @Query("q") location: String
    ): Call<List<SearchData.location>>

    @GET("")
    fun dummy(): Call<Any>
}
package com.example.weatherapplication.model

import retrofit2.Call

interface BaseModel {
    interface Listener{
        fun onFinished(locations: List<SearchData.location>?)
    }

    fun getCall(): Call<List<SearchData.location>>
}
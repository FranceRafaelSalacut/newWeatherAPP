package com.example.weatherapplication.repo

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import com.example.weatherapplication.model.SampleWeather

class WeatherRepositoryImpl : WeatherRepository {

    /*
    TODO:: Add a method to load weather from the database/network for the given city/user/Region.
    TODO: Add a method to load Forecast from the database/network for the given city/user/Region.
    TODO: Add a method to load settings from the network for the given city/user/Region.

    This is dummy data that can be used to test the UI, and is not used in the app.
    Note: This is not a good practice, and should be removed in production.
    The data should be loaded from the network/database.

    */
    val jsonRain: String =
        "{\"id\":804,\"main\":\"clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\", \"rain\":{\"amount\":20},\"clouds\":{\"all\":92}, \"wind\":{\"speed\":7.31,\"deg\":187.002}, \"temp\":289.5,\"humidity\":89,\"pressure\":1013,\"temp_min\":287.04,\"temp_max\":292.04}"
    val jsonSun: String =
        "{\"id\":804,\"main\":\"sunny\",\"description\":\"sunny\",\"icon\":\"04n\", \"rain\":{\"amount\":0},\"clouds\":{\"all\":92}, \"wind\":{\"speed\":7.31,\"deg\":187.002}, \"temp\":289.5,\"humidity\":89,\"pressure\":1013,\"temp_min\":287.04,\"temp_max\":292.04}"


    override fun sampleLoadWeather(): SampleWeather {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val json = jsonRain/*when ((1..2).shuffled().last()) {
            1 -> jsonRain
            else -> jsonSun
        }*/
        return moshi.adapter(SampleWeather::class.java).fromJson(json)!!
    }

}
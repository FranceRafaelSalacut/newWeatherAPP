package com.example.weatherapplication.repo

import com.example.weatherapplication.model.SampleWeather

interface WeatherRepository {
    fun sampleLoadWeather(): SampleWeather

    /*
    * TODO: Add methods to load weather from the network and database
    *
    * i.e
    *   fun loadWeatherFromNetwork(): SampleWeather
    *   fun loadWeatherFromDatabase(): SampleWeather
    *   fun loadWeather(): SampleWeather
    *   fun loadForecast(): Forecast
    *   fun loadSetting(): Setting
    * */
}
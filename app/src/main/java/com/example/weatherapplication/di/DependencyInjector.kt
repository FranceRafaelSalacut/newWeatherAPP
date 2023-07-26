package com.example.weatherapplication.di

import com.example.weatherapplication.model.SearchData
import com.example.weatherapplication.model.SearchModel
import com.example.weatherapplication.repo.WeatherRepository

interface DependencyInjector {
     /* fun weatherRepository() : WeatherRepository*/

      fun searchModel(): SearchModel
}

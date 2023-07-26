package com.example.weatherapplication.di

import com.example.weatherapplication.model.SearchData
import com.example.weatherapplication.model.SearchModel
import com.example.weatherapplication.model.SearchModel_Impl

class DependencyInjectorImpl : DependencyInjector {
    /*override fun weatherRepository(): WeatherRepository {
        return WeatherRepositoryImpl()
    }*/

    override fun searchModel(): SearchModel {
        return SearchModel_Impl()
    }
}

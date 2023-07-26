package com.example.weatherapplication.presenter

import android.app.appsearch.StorageInfo
import com.example.weatherapplication.model.BaseModel
import com.example.weatherapplication.model.SampleWeather
import com.example.weatherapplication.model.SearchData
import com.example.weatherapplication.repo.WeatherState
import com.example.weatherapplication.view.BaseView

interface SearchContract {

    interface presenter : BasePresenter, BaseModel.Listener{
        fun onViewCreated(query: String)
        fun onRefreshWeather()
    }

    interface View : BaseView<presenter>{
        fun displayWeatherState(sampleWeather: SampleWeather)

        //temporary functions
        fun Make_recycler(locations: List<SearchData.location>?)
    }
}
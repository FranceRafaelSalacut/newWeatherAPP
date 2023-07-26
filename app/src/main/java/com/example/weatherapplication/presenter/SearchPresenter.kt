package com.example.weatherapplication.presenter

import android.util.Log
import com.example.weatherapplication.di.DependencyInjector
import com.example.weatherapplication.model.SearchData
import com.example.weatherapplication.model.SearchModel
import com.example.weatherapplication.repo.WeatherRepository

class SearchPresenter( view: SearchContract.View, dependencyInjector: DependencyInjector ): SearchContract.presenter {

    private val searchModel: SearchModel = dependencyInjector.searchModel()
    private var view: SearchContract.View? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        Log.d("this", "was here first")
        searchModel.loadSearchData(this)
    }

    override fun onRefreshWeather() {
        TODO("Not yet implemented")
    }

    override fun onFinished(locations: List<SearchData.location>?) {
        view!!.Make_recycler(locations)
    }
}
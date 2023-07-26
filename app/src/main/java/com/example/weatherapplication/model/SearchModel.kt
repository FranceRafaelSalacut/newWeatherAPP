package com.example.weatherapplication.model

interface SearchModel: BaseModel {
    fun loadSearchData(listener: BaseModel.Listener)
}
package com.example.weatherapplication.model

class SearchData {
    class location(
        val id: Int,
        val name: String,
        val region: String,
        val country: String,
        val lat: Double,
        val lon: Double,
        val url: String
    )
}
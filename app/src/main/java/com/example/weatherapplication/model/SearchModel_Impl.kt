package com.example.weatherapplication.model

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchModel_Impl: SearchModel {

    private val ApiServices = RetrofitHelper.getInstance().create(ApiServices::class.java)

    override fun getCall(): Call<List<SearchData.location>> {
        TODO("SOMETHING")
    }

    override fun loadSearchData(listener: BaseModel.Listener) {
        val result = ApiServices.search_location(
            apiKey = Constant.apiKey,
            location = "Manila",
        )

        Log.d("this", result.request().url().toString())

        result.enqueue(object : Callback<List<SearchData.location>> {
            override fun onResponse(
                call: Call<List<SearchData.location>>,
                response: Response<List<SearchData.location>>
            ) {
                if (response.isSuccessful) {
                    Log.d("this", response.body().toString())
                    listener.onFinished(response.body())

                } else {
                    Log.d("this", "AINT ASUCCSFSDFSEFA")
                    listener.onFinished(null)
                }
            }

            override fun onFailure(call: Call<List<SearchData.location>>, t: Throwable) {
                Log.d("this", "FAILURE!! $t ")
                listener.onFinished(null)
            }
        })

    }
}
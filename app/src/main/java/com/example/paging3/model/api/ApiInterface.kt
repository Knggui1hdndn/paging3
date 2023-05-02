package com.example.phntrangtrongrcy.model.api

import com.example.phntrangtrongrcy.model.entity.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    companion object {
        var apiInterface: ApiInterface = Retrofit.Builder().baseUrl("https://reqres.in/api/users")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }



    @GET
     fun getDataAsync(@Query("page") page: Int): Deferred<ApiResponse>
}
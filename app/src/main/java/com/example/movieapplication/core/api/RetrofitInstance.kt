package com.example.movieapplication.core.api

import com.example.movieapplication.core.api.services.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val baseURL = "https://tastedive.com/"

    private fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val movieApi : MovieApi = getInstance().create(MovieApi::class.java)
}
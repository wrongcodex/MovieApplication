package com.example.movieapplication.core.api.services

import com.example.movieapplication.core.models.MovieDataResponse
import com.example.movieapplication.core.models.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("api/similar")
    suspend fun getMoviesFromApi(
        @Query("q") query: String,          // e.g., "movie:Dune, book:Hyperion"
        @Query("k") apiKey: String,         // Your API key
        @Query("type") type: String = "movie", // The type of results you want
        @Query("info") info: Int = 1,        // Set to 1 for extra details
        @Query("limit") limit: Int = 20      // Number of results
    ) : Response<MovieDataResponse>
}
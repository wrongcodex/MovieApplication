package com.example.movieapplication.core.repositories

import android.util.Log
import com.example.movieapplication.core.api.Api_key.api_key
import com.example.movieapplication.core.api.NetworkResponse
import com.example.movieapplication.core.api.services.MovieApi
import com.example.movieapplication.core.models.Result
import com.example.movieapplication.core.models.Similar
import com.example.movieapplication.core.models.testDiveApi.TestDiveApiModel
import com.google.gson.Gson

//class MovieRepositoryImp(
//    private val movieApi: MovieApi
//    ) : MovieRepository {
//    override suspend fun getMovies(movieName: String): NetworkResponse<Similar> {
//        return try {
//            val response = movieApi.getMoviesFromApi(query = movieName, apiKey = api_key)
//            if (response.isSuccessful && response.body() != null){
//                Log.d("RepoSuccess", "getMovie: ${response.body()}")
//                NetworkResponse.Success(response.body()!!.similar)
//                //Log.d("fdasfcaf", "getMovie: ${respose.body()}")// just for test
//            } else{
//                Log.d("fadfagh", "getMovie: ${response.errorBody()?.toString()}")// just for test
//                null
//            }
//        }catch (e : Exception){
//            Log.e("dfaf", "Exception Occur: ${e.message}" )
//            return null
//        }
//    }
//}

class MovieRepositoryImp(
    private val movieApi: MovieApi
) : MovieRepository {

    override suspend fun getMovies(movieName: String): NetworkResponse<TestDiveApiModel> {
        return try {
            val response = movieApi.getMoviesFromApi(query = movieName, apiKey = api_key)
            if (response.isSuccessful && response.body() != null) {
                val rawJsonResponse = response.body().toString() // Or use a JSON library to pretty print if it's complex
                Log.d("MovieRepository", "Raw JSON Response: $rawJsonResponse")
                val responseBody = response.body()
                Log.d("API_RAW_RESPONSE", "Full Response: ${Gson().toJson(responseBody)}")
                Log.d("API_SIMILAR", "Similar object: ${responseBody?.similar}")
                Log.d("API_RESULTS", "Results: ${responseBody?.similar?.results}")
                Log.d("API_INFO", "Info: ${responseBody?.similar?.info}")
                NetworkResponse.Success(response.body()!!)
            } else {
                NetworkResponse.Error("API error: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("RepoException", "Exception: ${e.message}")
            NetworkResponse.Error(e.message ?: "Unknown error")
        }
    }
}
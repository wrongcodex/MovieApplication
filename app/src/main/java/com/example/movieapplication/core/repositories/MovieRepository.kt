package com.example.movieapplication.core.repositories

import com.example.movieapplication.core.api.NetworkResponse
import com.example.movieapplication.core.models.Result
import com.example.movieapplication.core.models.Similar
import com.example.movieapplication.core.models.testDiveApi.TestDiveApiModel

interface MovieRepository {
    suspend fun getMovies(movieName: String): NetworkResponse<TestDiveApiModel>
}
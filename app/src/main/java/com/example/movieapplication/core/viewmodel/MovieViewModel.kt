package com.example.movieapplication.core.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.core.api.NetworkResponse
import com.example.movieapplication.core.api.RetrofitInstance
import com.example.movieapplication.core.api.services.MovieApi
import com.example.movieapplication.core.models.testDiveApi.Info
import com.example.movieapplication.core.models.testDiveApi.Result
import com.example.movieapplication.core.models.testDiveApi.TestDiveApiModel
import com.example.movieapplication.core.repositories.MovieRepositoryImp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val movieApi: MovieApi = RetrofitInstance.movieApi
    private val repo = MovieRepositoryImp(movieApi = movieApi)
    private val _movies = MutableStateFlow<List<Result>>(emptyList())
    val movies: StateFlow<List<Result>> = _movies

    private val _movieInfo = MutableStateFlow<List<Info>>(emptyList())
    val movieInfo: StateFlow<List<Info>> = _movieInfo

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _movieResult: MutableStateFlow<NetworkResponse<TestDiveApiModel>>  = MutableStateFlow(NetworkResponse.Loading)
    val movieResult: StateFlow<NetworkResponse<TestDiveApiModel>> = _movieResult

    fun getMoviess(movieName: String) {
        viewModelScope.launch {
            val result = repo.getMovies(movieName)
            _movieResult.value = result
        }
    }
}

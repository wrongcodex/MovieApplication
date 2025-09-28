package com.example.movieapplication.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.core.api.NetworkResponse
import com.example.movieapplication.core.api.RetrofitInstance
import com.example.movieapplication.core.api.services.MovieApi
import com.example.movieapplication.core.models.Result
import com.example.movieapplication.core.models.Info
import com.example.movieapplication.core.models.MovieDataResponse
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

    fun getMoviess(movieName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            when(val response = repo.getMovies(movieName)){
                is NetworkResponse.Success ->{
                    val similarData = response.data
                    _movies.value = similarData.results // Handle null results
                    _movieInfo.value = similarData.info // Handle null info
                    _isLoading.value = false
                    //_movies.value = response.data.results
                    //_movieInfo.value = response.data.info
                }

                is NetworkResponse.Error -> {
                    _movies.value = emptyList()
                    _movieInfo.value = emptyList()
                    _error.value = response.message
                }
                is NetworkResponse.Loading -> {
                    _isLoading.value = true
                }
            }
            _isLoading.value = true
        }
    }
}

package com.example.movieapplication.core.api


sealed class NetworkResponse<out T> {
    data class Success<out T>(val data: T) : NetworkResponse<T>()
    data class Error(val exception: String) : NetworkResponse<Nothing>()
    object Loading: NetworkResponse<Nothing>()
}
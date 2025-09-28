package com.example.movieapplication.core.models

import com.google.gson.annotations.SerializedName

data class MovieDataResponse(
    @SerializedName("similar")
    val similar: Similar
)
package com.example.movieapplication.core.models

import com.google.gson.annotations.SerializedName

//data class Similar(
//    val info: List<Info>,
//    val results: List<Result>
//)
data class Similar(
    @SerializedName("info")
    val info: List<Info>,
    @SerializedName("results")
    val results: List<Result>
)
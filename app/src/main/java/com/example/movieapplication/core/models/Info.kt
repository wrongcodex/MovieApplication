package com.example.movieapplication.core.models

import com.google.gson.annotations.SerializedName

//data class Info(
//    val name: String,
//    val type: String
//)
data class Info(
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Type")
    val type: String?
)
package com.example.movieapplication.core.models

import com.google.gson.annotations.SerializedName

//data class Result(
//    val description: String,
//    val name: String,
//    val wUrl: String,
//    val yID: String,
//    val yUrl: String
//)
data class Result(
    @SerializedName("wTeaser")
    val description: String?, // API returns "wTeaser", mapped to description

    @SerializedName("Name")
    val name: String?, // API returns "Name"

    @SerializedName("wUrl")
    val wUrl: String?, // Wikipedia URL

    @SerializedName("yID")
    val yID: String?, // YouTube ID

    @SerializedName("yUrl")
    val yUrl: String?, // YouTube URL

    @SerializedName("Type")
    val type: String? // API returns "Type"
)
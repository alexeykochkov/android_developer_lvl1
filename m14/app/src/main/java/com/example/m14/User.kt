package com.example.m14

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName ("results")
    val results:List<Result>
)

data class Result(
    @SerializedName ("gender")
    val gender: String,
    @SerializedName ("name")
    val name: Name
)

data class Name (
    @SerializedName("title")
    val title: String,
    @SerializedName ("first")
    val first: String,
    @SerializedName("last")
    val last: String
)


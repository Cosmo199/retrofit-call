package com.example.myretrofit2

import com.google.gson.annotations.SerializedName

data class Album(
    val userId: Int,
    val id:Int,
    @SerializedName("title")
    val title : String
)
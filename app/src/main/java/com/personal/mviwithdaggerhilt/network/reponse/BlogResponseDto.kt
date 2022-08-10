package com.personal.mviwithdaggerhilt.network.reponse

import com.google.gson.annotations.SerializedName

data class BlogResponseDto (
    @SerializedName("pk")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("image")
    val image: String
)
package com.personal.mviwithdaggerhilt.domain

data class Blog(
    val id: Int,
    val title: String,
    val body: String,
    val category: String,
    val image: String
)
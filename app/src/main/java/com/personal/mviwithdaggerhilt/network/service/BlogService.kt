package com.personal.mviwithdaggerhilt.network.service

import com.personal.mviwithdaggerhilt.network.reponse.BlogResponseDto
import retrofit2.http.GET

interface BlogService {

    @GET("blogs")
    suspend fun get(): List<BlogResponseDto>
}
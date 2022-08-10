package com.personal.mviwithdaggerhilt.di

import com.personal.mviwithdaggerhilt.domain.Blog
import com.personal.mviwithdaggerhilt.network.DomainMapperImpl
import com.personal.mviwithdaggerhilt.network.reponse.BlogResponseDto
import com.personal.mviwithdaggerhilt.network.service.BlogService
import com.personal.mviwithdaggerhilt.util.DomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesNetworkMapper(): DomainMapper<Blog, BlogResponseDto> = DomainMapperImpl()

    @Provides
    fun providesGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun providesRetrofitBuilder(factory: GsonConverterFactory): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(factory)
    }

    @Provides
    fun providesRetrofit(builder: Retrofit.Builder): BlogService {
        return builder
            .build()
            .create(BlogService::class.java)
    }

}
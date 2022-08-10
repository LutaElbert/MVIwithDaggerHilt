package com.personal.mviwithdaggerhilt.di

import android.content.Context
import com.personal.mviwithdaggerhilt.BaseApplication
import com.personal.mviwithdaggerhilt.domain.Blog
import com.personal.mviwithdaggerhilt.network.DomainMapperImpl
import com.personal.mviwithdaggerhilt.network.reponse.BlogResponseDto
import com.personal.mviwithdaggerhilt.util.DomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseApplication(@ApplicationContext context: Context): BaseApplication {
        return context as BaseApplication
    }
}
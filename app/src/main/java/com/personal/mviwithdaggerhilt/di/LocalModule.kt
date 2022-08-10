package com.personal.mviwithdaggerhilt.di

import android.content.Context
import androidx.room.Room
import com.personal.mviwithdaggerhilt.domain.Blog
import com.personal.mviwithdaggerhilt.local.BlogCacheEntity
import com.personal.mviwithdaggerhilt.local.BlogDao
import com.personal.mviwithdaggerhilt.local.BlogDatabase
import com.personal.mviwithdaggerhilt.local.CacheMapperImpl
import com.personal.mviwithdaggerhilt.util.DomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun providesCacheMapper(): DomainMapper<Blog, BlogCacheEntity> = CacheMapperImpl()

    @Provides
    fun providesBlogDb(@ApplicationContext context: Context): BlogDatabase {
        return Room.databaseBuilder(
            context,
            BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesBlogDao(database: BlogDatabase): BlogDao = database.blogDao()
}
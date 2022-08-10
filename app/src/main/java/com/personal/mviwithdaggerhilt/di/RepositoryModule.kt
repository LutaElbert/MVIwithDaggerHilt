package com.personal.mviwithdaggerhilt.di

import com.personal.mviwithdaggerhilt.local.BlogDao
import com.personal.mviwithdaggerhilt.local.CacheMapperImpl
import com.personal.mviwithdaggerhilt.network.DomainMapperImpl
import com.personal.mviwithdaggerhilt.network.service.BlogService
import com.personal.mviwithdaggerhilt.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesRepository(dao: BlogDao,
                           service: BlogService,
                           domainMapperImpl: DomainMapperImpl,
                           cacheMapperImpl: CacheMapperImpl): MainRepository {
        return MainRepository(dao, service, domainMapperImpl, cacheMapperImpl)
    }
}
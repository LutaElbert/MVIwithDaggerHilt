package com.personal.mviwithdaggerhilt.repository

import com.personal.mviwithdaggerhilt.local.BlogDao
import com.personal.mviwithdaggerhilt.local.CacheMapperImpl
import com.personal.mviwithdaggerhilt.network.DomainMapperImpl
import com.personal.mviwithdaggerhilt.network.service.BlogService
import com.personal.mviwithdaggerhilt.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val dao: BlogDao,
    private val retrofit: BlogService,
    private val networkMapper: DomainMapperImpl,
    private val cacheMapper: CacheMapperImpl
){

    suspend fun getBlog() = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val blogsResponse = retrofit.get()
            val blogs = networkMapper.mapListToDomain(blogsResponse)
            dao.insertAll(cacheMapper.mapListFromDomain(blogs))
            val cachedBlogs = dao.get()
            emit(DataState.Success(cacheMapper.mapListToDomain(cachedBlogs)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
            e.printStackTrace()
        }
    }
}
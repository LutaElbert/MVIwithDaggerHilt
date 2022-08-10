package com.personal.mviwithdaggerhilt.local

import com.personal.mviwithdaggerhilt.domain.Blog
import com.personal.mviwithdaggerhilt.util.DomainMapper
import javax.inject.Inject

class CacheMapperImpl
    @Inject constructor(): DomainMapper<Blog, BlogCacheEntity> {
    override fun mapFromDomain(domain: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domain.id,
            title = domain.title,
            category = domain.category,
            image = domain.image,
            body = domain.body
        )
    }

    override fun mapToDomain(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            category = entity.category,
            image = entity.image,
            body = entity.body
        )
    }

    fun mapListFromDomain(list: List<Blog>): List<BlogCacheEntity> = list.map { mapFromDomain(it) }

    fun mapListToDomain(list: List<BlogCacheEntity>): List<Blog> = list.map { mapToDomain(it) }
}
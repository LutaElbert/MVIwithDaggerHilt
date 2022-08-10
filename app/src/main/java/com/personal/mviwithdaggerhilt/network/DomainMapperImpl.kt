package com.personal.mviwithdaggerhilt.network

import com.personal.mviwithdaggerhilt.domain.Blog
import com.personal.mviwithdaggerhilt.network.reponse.BlogResponseDto
import com.personal.mviwithdaggerhilt.util.DomainMapper
import javax.inject.Inject

class DomainMapperImpl
    @Inject constructor(): DomainMapper<Blog, BlogResponseDto> {
    override fun mapFromDomain(domain: Blog): BlogResponseDto {
        return BlogResponseDto(
            id = domain.id,
            title = domain.title,
            category = domain.category,
            image = domain.image,
            body = domain.body
        )
    }

    override fun mapToDomain(entity: BlogResponseDto): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            category = entity.category,
            image = entity.image,
            body = entity.body
        )
    }

    fun mapListFromDomain(list: List<Blog>): List<BlogResponseDto> = list.map { mapFromDomain(it) }

    fun mapListToDomain(list: List<BlogResponseDto>): List<Blog> = list.map { mapToDomain(it) }
}
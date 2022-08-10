package com.personal.mviwithdaggerhilt.util

interface DomainMapper<Domain, Entity> {

    fun mapFromDomain(domain: Domain): Entity

    fun mapToDomain(entity: Entity): Domain
}
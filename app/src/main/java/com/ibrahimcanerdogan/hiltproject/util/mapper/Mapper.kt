package com.ibrahimcanerdogan.hiltproject.util.mapper

interface Mapper<Entity, Response> {

    fun mapToEntity(response: Response): Entity

    fun mapToEntityList(responses: List<Response>): List<Entity>
}
package com.ibrahimcanerdogan.hiltproject.data.local.entity

import com.ibrahimcanerdogan.hiltproject.data.remote.response.CommentResponse
import com.ibrahimcanerdogan.hiltproject.util.mapper.Mapper

class CommentEntityMapper: Mapper<CommentLocalEntity, CommentResponse.CommentResponseItem> {

    override fun mapToEntity(response: CommentResponse.CommentResponseItem): CommentLocalEntity {
        return CommentLocalEntity(
            id = response.id,
            postId = response.postId,
            name = response.name,
            email = response.email,
            body = response.body
        )
    }

    override fun mapToEntityList(responses: List<CommentResponse.CommentResponseItem>): List<CommentLocalEntity> {
        return responses.map {
            mapToEntity(it)
        }
    }

}
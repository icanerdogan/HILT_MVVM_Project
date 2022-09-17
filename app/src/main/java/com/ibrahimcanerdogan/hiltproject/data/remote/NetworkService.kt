package com.ibrahimcanerdogan.hiltproject.data.remote

import com.ibrahimcanerdogan.hiltproject.data.remote.response.CommentResponse
import retrofit2.http.GET

interface NetworkService {

    @GET(Endpoint.GET_ALL_COMMENTS)
    suspend fun getAllComments(): List<CommentResponse.CommentResponseItem>

}
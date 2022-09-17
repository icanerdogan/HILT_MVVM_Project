package com.ibrahimcanerdogan.hiltproject.repository

import com.ibrahimcanerdogan.hiltproject.data.local.entity.CommentLocalEntity
import com.ibrahimcanerdogan.hiltproject.util.ResultState
import kotlinx.coroutines.flow.Flow


interface CommentRepository {

    suspend fun getCommments(): Flow<ResultState<List<CommentLocalEntity>>>

}
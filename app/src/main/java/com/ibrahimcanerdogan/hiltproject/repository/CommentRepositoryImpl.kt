package com.ibrahimcanerdogan.hiltproject.repository

import com.ibrahimcanerdogan.hiltproject.data.local.dataaccessobject.CommentDao
import com.ibrahimcanerdogan.hiltproject.data.local.entity.CommentEntityMapper
import com.ibrahimcanerdogan.hiltproject.data.local.entity.CommentLocalEntity
import com.ibrahimcanerdogan.hiltproject.data.remote.NetworkService
import com.ibrahimcanerdogan.hiltproject.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class CommentRepositoryImpl(
    private val networkService: NetworkService,
    private val commentDao: CommentDao,
    private val commentEntityMapper: CommentEntityMapper
): CommentRepository {

    override suspend fun getCommments(): Flow<ResultState<List<CommentLocalEntity>>> = flow {
        emit(ResultState.Loading)
        try {
            val response = networkService.getAllComments()
            val commentList = commentEntityMapper.mapToEntityList(response)
            commentDao.insertMany(commentList)

            val comment = commentDao.getComments()
            emit(ResultState.Success(comment))
        } catch (e: Exception) {
            emit(ResultState.Error(e))
        }
    }

}
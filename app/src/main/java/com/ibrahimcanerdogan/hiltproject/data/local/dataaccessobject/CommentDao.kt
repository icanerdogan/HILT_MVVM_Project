package com.ibrahimcanerdogan.hiltproject.data.local.dataaccessobject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.hiltproject.data.local.entity.CommentLocalEntity
import java.util.TimerTask

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(comment: CommentLocalEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(comments: List<CommentLocalEntity>): List<Long>

    @Query("SELECT * FROM comments")
    suspend fun getComments(): List<CommentLocalEntity>
}
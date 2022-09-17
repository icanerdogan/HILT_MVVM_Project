package com.ibrahimcanerdogan.hiltproject.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahimcanerdogan.hiltproject.data.local.dataaccessobject.CommentDao
import com.ibrahimcanerdogan.hiltproject.data.local.entity.CommentLocalEntity

@Database(entities = [CommentLocalEntity::class], version = 1, exportSchema = false)
abstract class DatabaseService: RoomDatabase() {

    abstract fun commentDao(): CommentDao

}
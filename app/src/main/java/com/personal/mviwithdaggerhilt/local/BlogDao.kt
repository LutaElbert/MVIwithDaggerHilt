package com.personal.mviwithdaggerhilt.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogCacheEntity: BlogCacheEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(blogCacheEntity: List<BlogCacheEntity>)

    @Query("SELECT * FROM blogs")
    suspend fun get(): List<BlogCacheEntity>
}
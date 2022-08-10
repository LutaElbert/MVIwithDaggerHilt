package com.personal.mviwithdaggerhilt.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BlogCacheEntity::class], version = 2, exportSchema = false)
abstract class BlogDatabase : RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object {
        val DATABASE_NAME = "blog_database"
    }
}
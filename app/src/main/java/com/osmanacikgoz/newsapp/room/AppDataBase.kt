package com.osmanacikgoz.newsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osmanacikgoz.newsapp.model.entity.Article
import com.osmanacikgoz.newsapp.model.entity.Source

@Database(
    entities = [(Article::class),(Source::class)],
    version = 1 ,exportSchema = false
)
abstract class AppDataBase :RoomDatabase() {
    abstract fun NewsDao():NewsDao
}
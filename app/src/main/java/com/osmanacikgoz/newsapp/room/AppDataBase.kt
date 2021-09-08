package com.osmanacikgoz.newsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.osmanacikgoz.newsapp.model.entity.Favorites
import com.osmanacikgoz.newsapp.room.converter.NewsConverter

@Database(
    entities = [(Favorites::class)],
    version = 1, exportSchema = false
)
@TypeConverters(
    value = [
        (NewsConverter::class)
    ]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun newsDao(): FavoriteNewsDao
}

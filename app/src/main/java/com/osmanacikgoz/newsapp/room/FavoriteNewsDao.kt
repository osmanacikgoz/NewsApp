package com.osmanacikgoz.newsapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.osmanacikgoz.newsapp.model.entity.Favorites

@Dao
interface FavoriteNewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(favorites: Favorites)

    @Delete
    suspend fun deleteArticle(favorites: Favorites)

    @Query("SELECT title FROM Favorite")
    suspend fun getId(): List<String>

    @Query("SELECT * FROM Favorite")
    suspend fun getFavorites(): List<Favorites>

}
package com.osmanacikgoz.newsapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.osmanacikgoz.newsapp.model.entity.Article

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: List<Article>)

    @Update
    suspend fun updateArticle(article: Article)

    @Query("SELECT*FROM Article WHERE urlToImage IS NOT NULL")
    fun getAllColumns(): LiveData<List<Article>>

    // @Query("SELECT*FROM Article WHERE isFavorite")
    //fun getFavorite():LiveData<List<Article>>

    @Query("SELECT*FROM Article order by  publishedAt DESC LIMIT 10")
    fun getLastetNews(): LiveData<List<Article>>


}
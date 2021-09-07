package com.osmanacikgoz.newsapp.room

import androidx.room.*
import com.osmanacikgoz.newsapp.model.entity.Article

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: Article)

    @Query("SELECT*FROM News")
    fun getNewsList(): List<Article>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateArticle(article: Article)


}
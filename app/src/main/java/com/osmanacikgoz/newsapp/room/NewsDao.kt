package com.osmanacikgoz.newsapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.osmanacikgoz.newsapp.model.entity.Article
import com.osmanacikgoz.newsapp.model.entity.Source

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: List<Article>)

    @Update
    suspend fun updateArticle(article: Article)

    @Query("Select * from Article")
    fun getAllArticles(): LiveData<List<Article>>

     //@Query("SELECT*FROM Article WHERE isFavorite")
     //fun getFavorite():LiveData<List<Article>>

    @Query("SELECT*FROM Article order by  publishedAt DESC LIMIT 20")
    fun getLastetNews(): LiveData<List<Article>>


}
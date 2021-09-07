package com.osmanacikgoz.newsapp.repository

import androidx.lifecycle.asFlow
import com.osmanacikgoz.newsapp.api.NewsServices
import com.osmanacikgoz.newsapp.model.entity.Article
import com.osmanacikgoz.newsapp.room.NewsDao
import timber.log.Timber

class NewsRepository
    constructor(
        private val newsServices: NewsServices,
        private val newsDao: NewsDao
        ): Repository {
    init {
        Timber.d("Injection News")
    }

    fun  insertNews(article: Article) = newsDao.insertArticle(article)

    fun loadNews() = newsDao.getNewsList()


    fun getNews() {

    }
}
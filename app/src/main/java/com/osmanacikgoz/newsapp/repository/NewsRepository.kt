package com.osmanacikgoz.newsapp.repository

import androidx.lifecycle.asFlow
import com.osmanacikgoz.newsapp.api.NewsServices
import com.osmanacikgoz.newsapp.room.NewsDao
import timber.log.Timber

class NewsRepository
    constructor(
        private val newsDao: NewsDao
        ): Repository {
    init {
        Timber.d("Injection News")
    }

    fun loadNews() = newsDao.getAllArticles()
}
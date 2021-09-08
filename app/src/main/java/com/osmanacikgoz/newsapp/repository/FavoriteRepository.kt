package com.osmanacikgoz.newsapp.repository

import com.osmanacikgoz.newsapp.api.NewsServices
import com.osmanacikgoz.newsapp.room.FavoriteNewsDao
import timber.log.Timber

class FavoriteRepository
    constructor(
        private val newsServices: NewsServices,
        private val newsDao: FavoriteNewsDao
        ): Repository {
    init {
        Timber.d("Injection News")
    }


}
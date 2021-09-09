package com.osmanacikgoz.newsapp.view.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.osmanacikgoz.newsapp.api.NewsServices
import com.osmanacikgoz.newsapp.base.DispatchViewModel
import com.osmanacikgoz.newsapp.const.Const
import com.osmanacikgoz.newsapp.datasource.NewsDataSource
import com.osmanacikgoz.newsapp.model.entity.Article
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class NewsViewModel constructor(
    private val newsServices: NewsServices
) : DispatchViewModel() {

    private val _newsLiveData: MutableLiveData<Int> = MutableLiveData()

    init {
        Timber.d("Injection:NewsViewModel")
    }

    fun searchNews(searchParam: String): Flow<PagingData<Article>> {
        return Pager(PagingConfig(pageSize = Const.CONST_PAGE)) {
            NewsDataSource(newsServices, searchParam)
        }.flow.cachedIn(viewModelScope)
    }
}
package com.osmanacikgoz.newsapp.view.ui.news

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.switchMap
import com.osmanacikgoz.newsapp.base.DispatchViewModel
import com.osmanacikgoz.newsapp.model.entity.Article
import com.osmanacikgoz.newsapp.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class NewsViewModel constructor(
    private val newsRepository: NewsRepository
) : DispatchViewModel() {

    private val newsIdLiveData :MutableLiveData<Int> = MutableLiveData()
    val newsLiveData: LiveData<List<Article>> = newsRepository.loadNews()

    var isNewsLoading: ObservableBoolean = ObservableBoolean(false)

    init {
        Timber.d("Injection:NewsViewModel")

    }
}
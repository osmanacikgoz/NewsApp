package com.osmanacikgoz.newsapp.view.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.osmanacikgoz.newsapp.base.DispatchViewModel
import com.osmanacikgoz.newsapp.model.entity.Favorites
import com.osmanacikgoz.newsapp.room.FavoriteNewsDao
import kotlinx.coroutines.launch
import timber.log.Timber

class FavoriteViewModel(private val favoriteDao: FavoriteNewsDao) : DispatchViewModel() {

    private val _favoriteNewsLiveData = MutableLiveData<List<Favorites>>()
    val favoriteNewsLiveData: LiveData<List<Favorites>> get() = _favoriteNewsLiveData

    init {
        Timber.d("init FavoriteViewModel")

        fetchFavorites()
    }

    fun fetchFavorites() {
        viewModelScope.launch {
            _favoriteNewsLiveData.postValue(getFavoriteNewsList())
        }
    }

    private suspend fun getFavoriteNewsList(): List<Favorites> {
        return favoriteDao.getFavorites()
    }

}
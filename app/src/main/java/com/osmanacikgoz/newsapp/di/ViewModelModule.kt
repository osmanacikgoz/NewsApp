package com.osmanacikgoz.newsapp.di

import com.osmanacikgoz.newsapp.view.ui.favorite.FavoriteViewModel
import com.osmanacikgoz.newsapp.view.ui.news.NewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { NewsViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}
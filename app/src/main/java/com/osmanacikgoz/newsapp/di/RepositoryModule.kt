package com.osmanacikgoz.newsapp.di

import com.osmanacikgoz.newsapp.repository.FavoriteRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { FavoriteRepository(get(),get()) }
}
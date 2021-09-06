package com.osmanacikgoz.newsapp.di

import com.osmanacikgoz.newsapp.repository.NewsRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { NewsRepository(get()) }
}
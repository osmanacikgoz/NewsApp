package com.osmanacikgoz.newsapp.di

import androidx.room.Room
import com.osmanacikgoz.newsapp.room.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule  = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDataBase::class.java,"NewsApp.db")

    }
}
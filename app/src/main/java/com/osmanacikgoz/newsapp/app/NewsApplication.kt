package com.osmanacikgoz.newsapp.app

import android.app.Application
import com.osmanacikgoz.newsapp.di.networkModule
import com.osmanacikgoz.newsapp.di.persistenceModule
import com.osmanacikgoz.newsapp.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsApplication)
            modules(networkModule)
            modules(persistenceModule)
            modules(viewModels)

        }
    }
}
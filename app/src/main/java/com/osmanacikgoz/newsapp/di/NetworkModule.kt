package com.osmanacikgoz.newsapp.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.osmanacikgoz.newsapp.api.NewsServices
import com.osmanacikgoz.newsapp.api.RequestInterceptor
import com.osmanacikgoz.newsapp.const.Const
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(NewsServices::class.java)
    }
}
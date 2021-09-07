package com.osmanacikgoz.newsapp.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.osmanacikgoz.newsapp.api.Api
import com.osmanacikgoz.newsapp.api.NewsServices
import com.osmanacikgoz.newsapp.api.RequestInterceptor
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapter
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule =  module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(NewsServices::class.java)
    }
}
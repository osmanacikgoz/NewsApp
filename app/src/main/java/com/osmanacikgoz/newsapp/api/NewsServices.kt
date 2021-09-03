package com.osmanacikgoz.newsapp.api

import com.osmanacikgoz.newsapp.model.network.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") team:String,
        @Query("page") page:Int
    ):Call<NewsResponse>
}
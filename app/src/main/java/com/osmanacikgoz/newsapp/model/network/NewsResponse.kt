package com.osmanacikgoz.newsapp.model.network


import com.google.gson.annotations.SerializedName
import com.osmanacikgoz.newsapp.model.entity.Article

data class NewsResponse(
    val status: String?,
    val totalResults: Int?,
    val articles: List<Article>
)
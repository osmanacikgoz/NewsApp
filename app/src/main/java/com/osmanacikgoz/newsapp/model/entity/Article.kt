package com.osmanacikgoz.newsapp.model.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity
data class Article(
    val source: Source?,
    val author: @RawValue Any? = null,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
):Parcelable

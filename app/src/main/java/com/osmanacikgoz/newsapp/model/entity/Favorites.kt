package com.osmanacikgoz.newsapp.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Favorite")
data class Favorites(
    val source: Source?,
    val author: String? = "",
    @PrimaryKey
    val title: String = "News Title",
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
) : Parcelable

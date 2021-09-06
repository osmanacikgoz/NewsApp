package com.osmanacikgoz.newsapp.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity
data class Article(
   @SerializedName("source")
    val source: Source?,
   @SerializedName("author")
    val author:  String? = "",
   @SerializedName("title")
    val title: String?,
   @SerializedName("description")
    val description: String?,
   @SerializedName("url")
    val url: String?,
   @SerializedName("urlToImage")
    val urlToImage: String?,
   @PrimaryKey
   @SerializedName("publishedAt")
    val publishedAt: String,
   @SerializedName("content")
    val content: String?
):Parcelable

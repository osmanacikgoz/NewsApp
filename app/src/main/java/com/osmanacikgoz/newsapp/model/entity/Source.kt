package com.osmanacikgoz.newsapp.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Source(
    @PrimaryKey val id:String,
    val name: String
):Parcelable

package com.osmanacikgoz.newsapp.room.converter

import androidx.room.TypeConverter
import com.osmanacikgoz.newsapp.model.entity.Source

class NewsConverter {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}
package com.example.coroutines.CleanArchitecture.data.local

import androidx.room.TypeConverter
import com.example.coroutines.CleanArchitecture.data.models.MovieResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    // Convert List<MovieResult> to JSON
    @TypeConverter
    fun fromMovieResultList(value: List<MovieResult>?): String {
        return gson.toJson(value)
    }

    // Convert JSON back to List<MovieResult>
    @TypeConverter
    fun toMovieResultList(value: String): List<MovieResult>? {
        val listType = object : TypeToken<List<MovieResult>>() {}.type
        return gson.fromJson(value, listType)
    }

    // Convert List<Int> to JSON
    @TypeConverter
    fun fromIntList(value: List<Int>?): String {
        return gson.toJson(value)
    }

    // Convert JSON back to List<Int>
    @TypeConverter
    fun toIntList(value: String): List<Int>? {
        val listType = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(value, listType)
    }
}

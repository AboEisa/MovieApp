package com.example.coroutines.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters{

    private val gson = Gson()

    @TypeConverter
    fun fromAddress(value: List<Int>?): String? {
        return gson.toJson(value)  // Convert Address object to JSON string
    }

    @TypeConverter
    fun toAddress(value: String?): List<Int>? {
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(value, type)  // Convert JSON string back to Address object
    }
}

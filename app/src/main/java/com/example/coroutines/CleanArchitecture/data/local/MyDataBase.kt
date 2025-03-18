package com.example.coroutines.CleanArchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coroutines.CleanArchitecture.data.models.MovieResult


@Database(entities = [MovieResult::class], version = 6 , exportSchema = false)@TypeConverters(
    Converters::class)


abstract class MyDataBase : RoomDatabase() {

    abstract fun myDao(): MyDao


}
package com.example.coroutines.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coroutines.mvvm.home.MovieResult


@Dao
interface MyDao {
        @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
        suspend fun insertMovies(list: List<MovieResult>)

        @Query("SELECT * FROM MovieResult")
        suspend fun getMovies(): List<MovieResult>







}
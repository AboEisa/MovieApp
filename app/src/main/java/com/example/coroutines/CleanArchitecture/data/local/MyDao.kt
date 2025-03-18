package com.example.coroutines.CleanArchitecture.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coroutines.CleanArchitecture.data.models.MovieResult


@Dao
interface MyDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertMovies(list: List<MovieResult>)

        @Query("SELECT * FROM MovieResult")
        suspend fun getMovies(): List<MovieResult>







}
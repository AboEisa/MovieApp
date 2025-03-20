package com.example.coroutines.CleanArchitecture.data.local

import com.example.coroutines.CleanArchitecture.data.models.MovieModel
import com.example.coroutines.CleanArchitecture.data.models.MovieResult

interface ILocalDataSource {
    suspend fun getMovie(): List<MovieResult>
    suspend fun insert(movieResult: List<MovieResult>)
}

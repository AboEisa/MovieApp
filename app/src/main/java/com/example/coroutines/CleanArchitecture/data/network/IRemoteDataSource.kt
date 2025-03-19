package com.example.coroutines.CleanArchitecture.data.network

import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel
import com.example.coroutines.CleanArchitecture.data.models.MovieModel

interface IRemoteDataSource {

    suspend fun getMovie() : Result<MovieModel>
    suspend fun getMovieDetails(id : Int) : Result<MovieDetailsModel>
}
package com.example.coroutines.CleanArchitecture.data.network

import com.example.coroutines.CleanArchitecture.data.models.MovieModel
import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel

import retrofit2.http.GET
import retrofit2.http.Path

interface CallApi {


    @GET("discover/movie")
   suspend fun getMovies(): MovieModel

    @GET("movie/{movieId}")  // Assume endpoint requires movie ID as part of the URL
    suspend fun getMovieDetails(@Path("movieId") movieId: Int): MovieDetailsModel
}
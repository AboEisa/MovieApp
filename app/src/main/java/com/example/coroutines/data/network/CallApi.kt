package com.example.coroutines.data.network

import com.example.coroutines.mvvm.details.MovieDetailsModel
import com.example.coroutines.mvvm.home.MovieModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CallApi {


    @GET("discover/movie")
   suspend fun getMovies(): MovieModel

//   @GET("movie/{movie_id}")
//   suspend fun getMovieDetails(movieId : Int) : MovieDetailsModel

    @GET("movie/{movieId}")  // Assume endpoint requires movie ID as part of the URL
    suspend fun getMovieDetails(@Path("movieId") movieId: Int): MovieDetailsModel
}
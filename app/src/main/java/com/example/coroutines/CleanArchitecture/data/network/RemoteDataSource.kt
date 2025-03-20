package com.example.coroutines.CleanArchitecture.data.network

import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel
import com.example.coroutines.CleanArchitecture.data.models.MovieModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: CallApi) : IRemoteDataSource {

    override suspend fun getMovie(): Result<MovieModel> {
        return try {
            val data = apiService.getMovies()
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMovieDetails(id: Int): Result<MovieDetailsModel> {
        return try {
            val data = apiService.getMovieDetails(id)
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

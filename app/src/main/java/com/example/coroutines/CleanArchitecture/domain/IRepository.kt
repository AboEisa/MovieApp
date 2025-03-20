package com.example.coroutines.CleanArchitecture.domain

import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel
import com.example.coroutines.CleanArchitecture.data.models.MovieModel
import com.example.coroutines.CleanArchitecture.data.models.MovieResult

interface IRepository {
    suspend fun getMovie(): Result<DomainMovieModel>
    suspend fun getMovieDetails(id: Int): Result<DomainMovieDetailsModel>
    suspend fun insert(movieResult:List<DomainMovieResult>)


}

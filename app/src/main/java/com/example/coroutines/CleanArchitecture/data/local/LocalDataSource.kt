package com.example.coroutines.CleanArchitecture.data.local

import com.example.coroutines.CleanArchitecture.data.models.MovieResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val myDao: MyDao) : ILocalDataSource {


    override suspend fun insert(movieResult: List<MovieResult>) {
        movieResult.let {
            myDao.insertMovies(it)
        }
    }

    override suspend fun getMovie(): List<MovieResult>? {
        return myDao.getMovies()
    }


}
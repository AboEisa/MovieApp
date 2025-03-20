package com.example.coroutines.CleanArchitecture.data.local

import com.example.coroutines.CleanArchitecture.data.models.MovieResult
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val myDao: MyDao) : ILocalDataSource {




    override suspend fun getMovie(): List<MovieResult> {
        return myDao.getMovies()
    }

    override suspend fun insert(movieResult: List<MovieResult>) {
        myDao.insertMovies(movieResult)
    }


}

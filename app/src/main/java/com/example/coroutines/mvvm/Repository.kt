package com.example.coroutines.mvvm

import com.example.coroutines.mvvm.details.MovieDetailsModel
import com.example.coroutines.data.local.MyDao
import com.example.coroutines.data.network.CallApi
import com.example.coroutines.mvvm.home.MovieResult
import javax.inject.Inject

class Repository @Inject constructor(private val ApiServices: CallApi, private val dao : MyDao){

  suspend fun getMovie() : List<MovieResult>? {

      return getMovieRemote()
   }


    private suspend fun getMovieRemote() : List<MovieResult>? {

        return try {
             val data = ApiServices.getMovies()
            insert(data.results!!)
            data.results
        }catch (e : Exception){
             getMovieFromCache()
        }

    }
    
    suspend fun getMovieDetails(id : Int) : MovieDetailsModel {
        return ApiServices.getMovieDetails(id)
    }



    private suspend fun insert (movieResult : List<MovieResult>) {

        movieResult.let {
            dao.insertMovies(it)
        }
    }

    private suspend fun getMovieFromCache() : List<MovieResult> {
        return dao.getMovies()
    }


}
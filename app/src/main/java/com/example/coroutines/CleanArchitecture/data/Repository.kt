package com.example.coroutines.CleanArchitecture.data

import com.example.coroutines.CleanArchitecture.data.local.ILocalDataSource
import com.example.coroutines.CleanArchitecture.data.models.MovieModel

import com.example.coroutines.CleanArchitecture.data.models.MovieResult
import com.example.coroutines.CleanArchitecture.data.network.IRemoteDataSource
import com.example.coroutines.CleanArchitecture.data.network.RemoteDataSource
import com.example.coroutines.CleanArchitecture.domain.DomainMovieDetailsModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieModel
import com.example.coroutines.CleanArchitecture.domain.IRepository
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: IRemoteDataSource, private val localDataSource: ILocalDataSource) :IRepository {



    override suspend fun getMovie(): Result<DomainMovieModel> {
       val data = remoteDataSource.getMovie()
      return if (data.isSuccess){
           data
           localDataSource.insert( data.getOrNull()!!.results!!)
           Result.success(data.getOrNull()?.mapToDomain()!!)
       }else{
           localDataSource.getMovie()
           Result.failure(data.exceptionOrNull()!!)
       }
    }

    override suspend fun getMovieDetails(id: Int): Result<DomainMovieDetailsModel> {

        val data = remoteDataSource.getMovieDetails(id)
        return if (data.isSuccess){
            data
            Result.success(data.getOrNull()?.mapToDomain()!!)
        }else{
            Result.failure(data.exceptionOrNull()!!)
        }
    }


}
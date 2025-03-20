package com.example.coroutines.CleanArchitecture.data

import com.example.coroutines.CleanArchitecture.data.local.ILocalDataSource
import com.example.coroutines.CleanArchitecture.data.models.MovieResult
import com.example.coroutines.CleanArchitecture.data.network.IRemoteDataSource
import com.example.coroutines.CleanArchitecture.domain.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
) : IRepository {

    override suspend fun getMovie(): Result<DomainMovieModel> {
        return try {
            val data = remoteDataSource.getMovie()
            if (data.isSuccess) {
                data
                insert(data.getOrNull()!!.results!!.map { it.mapToDomain() })
                Result.success(data.getOrNull()!!.mapToDomain())
            } else {
                localDataSource.getMovie()
                Result.failure(data.exceptionOrNull()!!)
            }
        } catch (e: Exception) {

            Result.failure(e)
        }
    }

    override suspend fun getMovieDetails(id: Int): Result<DomainMovieDetailsModel> {
        return try {
            val data = remoteDataSource.getMovieDetails(id)
            if (data.isSuccess) {
                data
                Result.success(data.getOrNull()!!.mapToDomain())
            } else {
                Result.failure(data.exceptionOrNull()!!)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun insert(movieResult: List<DomainMovieResult>) {
        localDataSource.insert(movieResult.map { it.mapToEntity() })
    }


}

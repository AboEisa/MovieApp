package com.example.coroutines.CleanArchitecture.data

import com.example.coroutines.CleanArchitecture.data.local.ILocalDataSource
import com.example.coroutines.CleanArchitecture.data.network.IRemoteDataSource
import com.example.coroutines.CleanArchitecture.domain.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
) : IRepository {

    override suspend fun getMovie(): Result<DomainMovieModel> {
        return try {
            val remoteData = remoteDataSource.getMovie()
            if (remoteData.isSuccess) {
                val movieResults = remoteData.getOrNull()?.results?.map { it.mapToDomain() } ?: emptyList()
                insert(movieResults)
                Result.success(remoteData.getOrNull()?.mapToDomain() ?: DomainMovieModel(0, emptyList(), 0, 0))
            } else {
                val localData = localDataSource.getMovie()
                Result.success(DomainMovieModel(0, localData.map { it.mapToDomain() }, 0, localData.size))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMovieDetails(id: Int): Result<DomainMovieDetailsModel> {
        return try {
            val data = remoteDataSource.getMovieDetails(id)
            if (data.isSuccess) {
//                val movieDetails = data.getOrNull()?.mapToDomain() ?: DomainMovieDetailsModel("Unknown", "", "", "", null)
//                insert(listOf(movieDetails.mapToDomain()))
                Result.success(data.getOrNull()?.mapToDomain() ?: DomainMovieDetailsModel("Unknown", "", "", "", null))
            } else {
                Result.failure(data.exceptionOrNull() ?: Exception("Unknown error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun insert(movieResult: List<DomainMovieResult>) {
        localDataSource.insert(movieResult.map { it.mapToEntity() })
    }
}
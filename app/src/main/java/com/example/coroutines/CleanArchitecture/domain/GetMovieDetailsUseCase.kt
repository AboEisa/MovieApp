package com.example.coroutines.CleanArchitecture.domain

import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: IRepository) {

    suspend fun getMovieDetails(id : Int) : Result<DomainMovieDetailsModel> {
        return repository.getMovieDetails(id)
    }

}
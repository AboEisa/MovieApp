package com.example.coroutines.CleanArchitecture.domain



interface IRepository {


    suspend fun getMovie() : Result<DomainMovieModel>
    suspend fun getMovieDetails(id : Int) : Result<DomainMovieDetailsModel>


//    suspend fun getMovieFromCache() : Result<DomainMovieModel>



}
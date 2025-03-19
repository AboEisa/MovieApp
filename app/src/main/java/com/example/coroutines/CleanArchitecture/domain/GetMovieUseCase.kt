package com.example.coroutines.CleanArchitecture.domain


import javax.inject.Inject

class GetMovieUseCase @Inject constructor(val repository: IRepository) {

        suspend fun getMovie() : Result<DomainMovieModel> {
          return  repository.getMovie()
        }

}
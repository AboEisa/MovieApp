package com.example.coroutines.CleanArchitecture.domain

data class DomainMovieModel(

    val results: List<DomainMovieResult>?,

)
data class DomainMovieResult(
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val title: String?,
    val vote_average: Double?,
    val id: Int?,
    val poster_path: String?
)
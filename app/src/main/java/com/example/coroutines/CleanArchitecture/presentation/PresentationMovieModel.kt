package com.example.coroutines.CleanArchitecture.presentation

data class PresentationMovieModel(

    val results: List<PresentationMovieResult>?,

)
data class PresentationMovieResult(
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val title: String?,
    val vote_average: Double?,
    val id: Int?,
    val poster_path: String?

)
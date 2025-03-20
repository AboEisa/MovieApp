package com.example.coroutines.CleanArchitecture.domain

import androidx.room.PrimaryKey

data class DomainMovieModel(
    val page: Int?,
    val results: List<DomainMovieResult>?,
    val total_pages: Int?,
    val total_results: Int?

)
data class DomainMovieResult(
    val adult: Boolean?,
    val backdrop_path: String?,
    val id: Int, // Primary Key must be non-null
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?,
    val genre_ids: List<Int>? // Room doesn't support lists directly, so we added TypeConverters
)
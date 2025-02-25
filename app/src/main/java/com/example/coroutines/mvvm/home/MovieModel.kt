package com.example.coroutines.mvvm.home

import androidx.room.Entity
import androidx.room.PrimaryKey

data class MovieModel(
    val page: Int?,
    val results: List<MovieResult>?,
    val total_pages: Int?,
    val total_results: Int?
)
@Entity
data class MovieResult(
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
   @PrimaryKey
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)
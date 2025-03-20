package com.example.coroutines.CleanArchitecture.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.coroutines.CleanArchitecture.data.local.Converters
@Entity
data class MovieModel(
    @PrimaryKey(autoGenerate = true)
    val page: Int?,
    @TypeConverters(Converters::class)
    val results: List<MovieResult>?,
    val total_pages: Int?,
    val total_results: Int?
)

@Entity
@TypeConverters(Converters::class) // Added TypeConverters for lists
data class MovieResult(
    val adult: Boolean?,
    val backdrop_path: String?,
    @PrimaryKey
    val id: Int,
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

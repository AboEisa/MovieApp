package com.example.coroutines.CleanArchitecture.data



import com.example.coroutines.CleanArchitecture.data.models.BelongsToCollection
import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel
import com.example.coroutines.CleanArchitecture.data.models.MovieModel
import com.example.coroutines.CleanArchitecture.data.models.MovieResult
import com.example.coroutines.CleanArchitecture.domain.DomainBelongsToCollection
import com.example.coroutines.CleanArchitecture.domain.DomainMovieDetailsModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieResult



fun MovieModel.mapToDomain(): DomainMovieModel {
    return DomainMovieModel(
        page = page ?: 0,
        results = results?.map { it.mapToDomain() } ?: emptyList(),
        total_pages = total_pages ?: 0,
        total_results = total_results ?: 0
    )
}

fun MovieResult.mapToDomain(): DomainMovieResult {
    return DomainMovieResult(
        adult = adult ?: false,
        backdrop_path = backdrop_path ?: "",
        genre_ids = genre_ids ?: emptyList(),
        title = title ?: "Unknown",
        vote_average = vote_average ?: 0.0,
        id = id,
        poster_path = poster_path ?: "",
        original_language = original_language ?: "",
        original_title = original_title ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        release_date = release_date ?: "",
        video = video ?: false,
        vote_count = vote_count ?: 0
    )
}

fun MovieDetailsModel.mapToDomain(): DomainMovieDetailsModel {
    return DomainMovieDetailsModel(
        title = title,
        release_date = release_date,
        overview = overview,
        poster_path = poster_path,
        belongs_to_collection = belongs_to_collection?.map { it?.mapToDomain() } ?: emptyList()
    )
}

fun BelongsToCollection.mapToDomain(): DomainBelongsToCollection {
    return DomainBelongsToCollection(
        backdrop_path = backdrop_path,
        id = id,
        name = name,
        poster_path = poster_path
    )
}

fun DomainMovieModel.mapToEntity(): MovieModel {
    return MovieModel(
        page = page ?: 0,
        results = results?.map { it.mapToEntity() } ?: emptyList(),
        total_pages = total_pages ?: 0,
        total_results = total_results ?: 0
    )
}

fun DomainMovieResult.mapToEntity(): MovieResult {
    return MovieResult(
        adult = adult ?: false,
        backdrop_path = backdrop_path ?: "",
        genre_ids = genre_ids ?: emptyList(),
        title = title ?: "Unknown",
        vote_average = vote_average ?: 0.0,
        id = id,
        poster_path = poster_path ?: "",
        original_language = original_language ?: "",
        original_title = original_title ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        release_date = release_date ?: "",
        video = video ?: false,
        vote_count = vote_count ?: 0
    )
}












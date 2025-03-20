package com.example.coroutines.CleanArchitecture.data

import com.example.coroutines.CleanArchitecture.data.models.*
import com.example.coroutines.CleanArchitecture.domain.*

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
        id = id ?: 0,
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
        title = title ?: "Unknown",
        release_date = release_date ?: "",
        overview = overview ?: "",
        poster_path = poster_path ?: "",
        belongs_to_collection = belongs_to_collection?.map {  it.mapToDomain() }
    )
}

fun BelongsToCollection?.mapToDomain(): DomainBelongsToCollection? {
    return this?.let {
        DomainBelongsToCollection(
            backdrop_path = backdrop_path ?: "",
            id = id ?: 0,
            name = name ?: "",
            poster_path = poster_path ?: ""
        )
    }
}



fun DomainMovieResult.mapToEntity(): MovieResult {
    return MovieResult(
        adult = adult,
        backdrop_path = backdrop_path,
        genre_ids = genre_ids,
        title = title,
        vote_average = vote_average,
        id = id,
        poster_path = poster_path,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        release_date = release_date,
        video = video,
        vote_count = vote_count
    )
}
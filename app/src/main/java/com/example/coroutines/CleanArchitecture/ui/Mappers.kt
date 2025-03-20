package com.example.coroutines.CleanArchitecture.ui

import com.example.coroutines.CleanArchitecture.domain.DomainBelongsToCollection
import com.example.coroutines.CleanArchitecture.domain.DomainMovieDetailsModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieResult

fun DomainMovieModel.mapToPresentation(): PresentationMovieModel {
    return PresentationMovieModel(
        results = results?.map { it.mapToPresentation() } ?: emptyList()
    )
}

fun DomainMovieResult.mapToPresentation(): PresentationMovieResult {
    return PresentationMovieResult(
        adult = adult,
        backdrop_path = backdrop_path,
        genre_ids = genre_ids,
        title = title,
        vote_average = vote_average,
        id = id,
        poster_path = poster_path
    )
}

fun DomainMovieDetailsModel.mapToPresentation(): PresentationMovieDetailsModel {
    return PresentationMovieDetailsModel(
        title = title,
        release_date = release_date,
        overview = overview,
        poster_path = poster_path,
        belongs_to_collection = belongs_to_collection?.map { it?.mapToPresentation() } ?: emptyList()
    )
}

fun DomainBelongsToCollection.mapToPresentation(): PresentationBelongsToCollection {
    return PresentationBelongsToCollection(
        backdrop_path = backdrop_path,
        id = id,
        name = name,
        poster_path = poster_path
    )
}



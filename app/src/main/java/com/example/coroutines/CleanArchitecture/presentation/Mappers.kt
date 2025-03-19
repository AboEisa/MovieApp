package com.example.coroutines.CleanArchitecture.presentation

import com.example.coroutines.CleanArchitecture.data.mapToDomain
import com.example.coroutines.CleanArchitecture.domain.DomainBelongsToCollection
import com.example.coroutines.CleanArchitecture.domain.DomainMovieDetailsModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieResult

fun DomainMovieModel.mapToPresentation() : PresentationMovieModel{
    return PresentationMovieModel(results?.map { it.mapToPresentation() })
}
fun DomainMovieResult.mapToPresentation() : PresentationMovieResult{
    return PresentationMovieResult(adult,backdrop_path,genre_ids,title,vote_average,id,poster_path)
}

fun DomainMovieDetailsModel.mapToPresentation(): PresentationMovieDetailsModel {
    return PresentationMovieDetailsModel(title, release_date, overview, poster_path,belongs_to_collection?.map { it?.mapToPresentation() } ?: emptyList())
}


fun DomainBelongsToCollection.mapToPresentation(): PresentationBelongsToCollection {
    return PresentationBelongsToCollection(backdrop_path, id, name, poster_path)
}


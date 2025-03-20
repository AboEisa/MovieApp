package com.example.coroutines.CleanArchitecture.domain


data class DomainMovieDetailsModel(
    val title: String,
    val release_date: String,
    val overview: String,
    val poster_path: String,
    val belongs_to_collection: List<DomainBelongsToCollection?>?,

    )

data class DomainBelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)

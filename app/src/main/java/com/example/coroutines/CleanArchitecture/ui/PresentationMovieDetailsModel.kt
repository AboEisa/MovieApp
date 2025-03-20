package com.example.coroutines.CleanArchitecture.ui

data class PresentationMovieDetailsModel(

    val title: String,
    val release_date: String,
    val overview: String,
    val poster_path: String,
    val belongs_to_collection: List<PresentationBelongsToCollection?>,

)

data class PresentationBelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)








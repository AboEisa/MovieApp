package com.example.coroutines.CleanArchitecture.presentation

import androidx.room.PrimaryKey
import com.example.coroutines.CleanArchitecture.data.models.Genre
import com.example.coroutines.CleanArchitecture.data.models.SpokenLanguage

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








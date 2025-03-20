package com.example.coroutines.CleanArchitecture.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.coroutines.CleanArchitecture.data.local.Converters

@Entity
@TypeConverters(Converters::class) // Added TypeConverters for lists
data class MovieDetailsModel(
    val adult: Boolean,
    val backdrop_path: String,
    val budget: Int,
    val homepage: String,
    @PrimaryKey
    val id: Int, // Ensuring the primary key is non-null
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,

    val belongs_to_collection: List<BelongsToCollection?>,
    val genres: List<Genre>,
    val origin_country: List<String>,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val spoken_languages: List<SpokenLanguage>
)

data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)

data class Genre(
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
)

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)

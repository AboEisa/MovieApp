package com.example.coroutines.CleanArchitecture.data



import com.example.coroutines.CleanArchitecture.data.models.BelongsToCollection
import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel
import com.example.coroutines.CleanArchitecture.data.models.MovieModel
import com.example.coroutines.CleanArchitecture.data.models.MovieResult
import com.example.coroutines.CleanArchitecture.domain.DomainBelongsToCollection
import com.example.coroutines.CleanArchitecture.domain.DomainMovieDetailsModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieModel
import com.example.coroutines.CleanArchitecture.domain.DomainMovieResult



fun MovieModel.mapToDomain (): DomainMovieModel{
    return DomainMovieModel(results?.map { it.mapToDomain() })
}

fun MovieResult.mapToDomain (): DomainMovieResult{
    return DomainMovieResult(adult,backdrop_path,genre_ids,title,vote_average,id,poster_path)

}


fun MovieDetailsModel.mapToDomain(): DomainMovieDetailsModel {
    return DomainMovieDetailsModel(title, release_date, overview, poster_path,belongs_to_collection?.map { it?.mapToDomain() } ?: emptyList()
    )
}


fun BelongsToCollection.mapToDomain() : DomainBelongsToCollection{
    return DomainBelongsToCollection(backdrop_path, id, name, poster_path)
}






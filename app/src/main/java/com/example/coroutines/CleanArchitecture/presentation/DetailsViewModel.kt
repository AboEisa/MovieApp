package com.example.coroutines.CleanArchitecture.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines.CleanArchitecture.data.Repository
import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel
import com.example.coroutines.CleanArchitecture.domain.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) : ViewModel() {

    private val _movieDetailsLiveDat = MutableLiveData<PresentationMovieDetailsModel>()
    val movieDetailsLiveDat get() = _movieDetailsLiveDat



    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getMovieDetailsUseCase.getMovieDetails(movieId)
            _movieDetailsLiveDat.postValue(data.getOrNull()?.mapToPresentation())
        }
    }
}
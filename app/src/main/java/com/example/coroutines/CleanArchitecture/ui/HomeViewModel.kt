package com.example.coroutines.CleanArchitecture.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines.CleanArchitecture.domain.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _movieLiveData = MutableLiveData<List<PresentationMovieResult>?>()
    val movieLiveData get() = _movieLiveData

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getMovieUseCase.getMovie()
            if (result.isSuccess) {
                _movieLiveData.postValue(result.getOrNull()?.mapToPresentation()?.results)
            } else {
                _movieLiveData.postValue(null)
            }
        }
    }
}
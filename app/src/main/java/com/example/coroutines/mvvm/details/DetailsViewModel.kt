package com.example.coroutines.mvvm.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines.mvvm.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _movieDetailsLiveDat = MutableLiveData<MovieDetailsModel?>()
    val movieDetailsLiveDat get() = _movieDetailsLiveDat


    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getMovieDetails(movieId)
            _movieDetailsLiveDat.postValue(data)
        }
    }
}

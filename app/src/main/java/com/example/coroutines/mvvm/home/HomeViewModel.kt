package com.example.coroutines.mvvm.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines.mvvm.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val repository: Repository) : ViewModel() {


    private val _movieLiveDat = MutableLiveData<List<MovieResult>?>()
    val movieLiveData get() = _movieLiveDat

    init {
        getMovie()
    }
     private fun getMovie (){
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getMovie()
            _movieLiveDat.postValue(data)
        }
    }











}

package com.example.coroutines.mvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.coroutines.databinding.ActivityMain2Binding
import com.example.coroutines.mvvm.home.MovieAdapter

class Main2Activity : AppCompatActivity() {

    val binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)








    }
}
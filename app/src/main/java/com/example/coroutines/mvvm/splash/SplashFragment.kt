package com.example.coroutines.mvvm.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.coroutines.R

import com.example.coroutines.databinding.FragmentSplashBinding
import com.google.android.material.animation.AnimationUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment :Fragment() {

    private var _binding : FragmentSplashBinding? = null
    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        //for splash screen
        Handler(Looper.getMainLooper())
            .postDelayed({
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            }, 2000)
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
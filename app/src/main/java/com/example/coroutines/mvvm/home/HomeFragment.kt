package com.example.coroutines.mvvm.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coroutines.R

import com.example.coroutines.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :Fragment() {

     var _binding : FragmentHomeBinding? = null
     val binding get() = _binding!!
     val homeViewModel : HomeViewModel by viewModels ()

    private val movieAdapter by lazy {
        MovieAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        observers()

        movieAdapter.onItemClick = object : MovieAdapter.OnItemClick{
            override fun onClick(id: Int) {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(id))
            }
        }
    }


     private fun observers(){
        homeViewModel.movieLiveData.observe(viewLifecycleOwner){
            movieAdapter.movieList = it as? ArrayList<MovieResult>
            binding.recyclerMovie.adapter = movieAdapter

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
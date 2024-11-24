package com.example.coroutines.mvvm.details

import DetailsAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coroutines.R

import com.example.coroutines.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment :Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    val binding get() = _binding!!

    private val detailsViewModel : DetailsViewModel by viewModels ()

    private val detailsAdapter by lazy {
        DetailsAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailsBinding.bind(view)

        val movieId = DetailsFragmentArgs.fromBundle(requireArguments()).id
        detailsViewModel.getMovieDetails(movieId)
        observers()
    }

    private fun observers(){

        detailsViewModel.movieDetailsLiveDat.observe(viewLifecycleOwner){
            detailsAdapter.movieDetails =  it as? MovieDetailsModel
            binding.recyclerMovieDetails.adapter =  detailsAdapter

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
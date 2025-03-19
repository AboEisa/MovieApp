package com.example.coroutines.CleanArchitecture.presentation

import com.example.coroutines.CleanArchitecture.presentation.DetailsAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coroutines.R
import com.example.coroutines.databinding.FragmentDetailsBinding
import com.example.coroutines.CleanArchitecture.data.models.MovieDetailsModel
import com.example.coroutines.service.MyServices
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    val binding get() = _binding!!

    private val detailsViewModel : DetailsViewModel by viewModels()

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

        requireActivity().apply {
            startService(Intent(this, MyServices::class.java))
        }
    }

    private fun observers(){
        detailsViewModel.movieDetailsLiveDat.observe(viewLifecycleOwner){
            detailsAdapter.movieDetails = it
            binding.recyclerMovieDetails.adapter =  detailsAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
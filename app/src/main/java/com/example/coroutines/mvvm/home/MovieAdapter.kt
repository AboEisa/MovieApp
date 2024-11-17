package com.example.coroutines.mvvm.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coroutines.R

import com.example.coroutines.databinding.ItemMovieBinding


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.Holder>() {


    var movieList : ArrayList<MovieResult> ?=null

    var onItemClick : OnItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        movieList?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }


    inner class Holder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {


        init {

            binding.root.setOnClickListener {
                movieList?.get(adapterPosition)?.id?.let {
                    onItemClick?.onClick(it)
                }
            }
        }

        fun bind( movieResult: MovieResult) {
            binding.apply {
               movieTitle.text = movieResult.title
                movieRating.text = movieResult.vote_average.toString()

                Glide.with(binding.root)
                    .load("https://image.tmdb.org/t/p/w500"+movieResult.poster_path)
                    .placeholder( R.drawable.place_holder)
                    .into(moviePoster)


            }
        }


    }

    interface OnItemClick{
        fun onClick(id : Int)

    }
}
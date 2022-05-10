package com.ramirotorrejon.moviewscratch.features.movie.uimovieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramirotorrejon.moviewscratch.databinding.MoviesListItemBinding
import com.ramirotorrejon.moviewscratch.utils.ImageUtils

class MoviesViewHolder private constructor(
	private val binding: MoviesListItemBinding): RecyclerView.ViewHolder(binding.root) {

	fun bind(uiMovie: UiMovie) {
		val imageUrl = ImageUtils.buildImageURL(uiMovie.imagePath.trim('/'))

		Glide.with(binding.root).load(imageUrl.toString()).into(binding.ivMoviePoster)
		binding.root.setOnClickListener { navigateToMovie(uiMovie, it) }
	}

	private fun navigateToMovie(uiMovie: UiMovie, view: View) {
		val direction = MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailFragment(uiMovie)
		view.findNavController().navigate(direction)
	}

	companion object {
		fun from(parent: ViewGroup): MoviesViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = MoviesListItemBinding.inflate(layoutInflater, parent, false)

			return MoviesViewHolder(binding)
		}
	}

}
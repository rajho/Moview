package com.ramirotorrejon.moviewscratch.features.movie.uimoviedetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ramirotorrejon.moviewscratch.R
import com.ramirotorrejon.moviewscratch.databinding.MovieDetailFragmentBinding
import com.ramirotorrejon.moviewscratch.features.movie.uimovieslist.UiMovie
import com.ramirotorrejon.moviewscratch.utils.ImageUtils

class MovieDetailFragment : Fragment() {

	companion object {
		fun newInstance() = MovieDetailFragment()
	}

	private lateinit var viewModel: MovieDetailViewModel
	private lateinit var movie: UiMovie
	private lateinit var binding: MovieDetailFragmentBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = MovieDetailFragmentBinding.inflate(inflater, container, false)

		val arguments = MovieDetailFragmentArgs.fromBundle(requireArguments())
		movie = arguments.movie

		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		displayMovie()
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
		// TODO: Use the ViewModel
	}

	private fun displayMovie() {
		val imageUrl = ImageUtils.buildImageURL(movie.imagePath.trim('/'))
		Glide.with(this).load(imageUrl.toString()).into(binding.ivMovie)

		binding.run {
			tvTitle.text = movie.title
			tvReleaseDate.text = movie.releaseDate
			tvPlot.text = movie.plotSynopsis
		}
	}

}
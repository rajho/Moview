package com.ramirotorrejon.moviewscratch.features.movie.uimoviedetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ramirotorrejon.moviewscratch.R

class MovieDetailFragment : Fragment() {

	companion object {
		fun newInstance() = MovieDetailFragment()
	}

	private lateinit var viewModel: MovieDetailViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.movie_detail_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
		// TODO: Use the ViewModel
	}

}
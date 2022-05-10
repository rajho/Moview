package com.ramirotorrejon.moviewscratch.features.movie.uimovieslist

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.ramirotorrejon.moviewscratch.R
import com.ramirotorrejon.moviewscratch.databinding.MoviesListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import kotlin.math.floor
import kotlin.math.max

@AndroidEntryPoint
class MoviesListFragment : Fragment() {

	companion object {
		fun newInstance() = MoviesListFragment()
	}

	private val viewModel: MoviesListViewModel by viewModels()
	private lateinit var binding: MoviesListFragmentBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = MoviesListFragmentBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.errorMessageText.setOnClickListener (
			Navigation.createNavigateOnClickListener(R.id.action_moviesListFragment_to_movieDetailFragment)
		)

		val columnWidthDp: Int = 180
		val gridLayoutManager = GridLayoutManager(requireContext(), calculateBestSpanCount(columnWidthDp))
		val moviesAdapter = MoviesAdapter()

		binding.moviesRecycler.run {
			layoutManager = gridLayoutManager
			setHasFixedSize(true)
			adapter = moviesAdapter
		}

		viewModel.movies.observe(viewLifecycleOwner) { movies ->
			Timber.d("Ramiro movies size ${movies.size}")
			moviesAdapter.submitList(movies)
		}

	}

	private fun calculateBestSpanCount(posterWidthDP: Int): Int {
		val metrics = DisplayMetrics()
		requireActivity().windowManager.defaultDisplay.getMetrics(metrics)
		val logicalDensity = metrics.density
		val widthInPixels = posterWidthDP * logicalDensity
		val spanCount = floor((metrics.widthPixels / widthInPixels).toDouble()).toInt()
		return max(spanCount, 2)
	}
}
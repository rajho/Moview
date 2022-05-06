package com.ramirotorrejon.moviewscratch.features.movie.uimovieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ramirotorrejon.moviewscratch.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {
	private val viewModel by viewModels<MoviesViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_movies)

		viewModel.movies.observe(this) { movies ->
			Timber.d("Ramiro movies size ${movies.size}")
		}
	}
}
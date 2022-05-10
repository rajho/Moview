package com.ramirotorrejon.moviewscratch.features.movie.uimovieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramirotorrejon.moviewscratch.features.movie.datasource.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
	private val moviesRepository: MoviesRepository) : ViewModel() {
	private val _movies = MutableLiveData<List<UiMovie>>()
	private val _errorResponse = MutableLiveData(false)

	val movies: LiveData<List<UiMovie>>
		get() = _movies
	val errorResponse: LiveData<Boolean>
		get() = _errorResponse

	init {
		loadMoviesData()
	}

	private fun loadMoviesData() {
		viewModelScope.launch {
			try {
				_movies.value = moviesRepository.getPopularMovies()
			} catch (e: Exception) {
				_errorResponse.value = true
			}
		}
	}
}
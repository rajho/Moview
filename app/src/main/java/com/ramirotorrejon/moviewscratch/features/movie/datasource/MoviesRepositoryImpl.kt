package com.ramirotorrejon.moviewscratch.features.movie.datasource

import com.ramirotorrejon.moviewscratch.features.movie.datasource.remote.asUiMovie
import com.ramirotorrejon.moviewscratch.features.movie.uimovieslist.UiMovie
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
	private val moviesLocalSource: MoviesSource.Local,
	private val moviesRemoteSource: MoviesSource.Remote
) : MoviesRepository {
	override suspend fun getPopularMovies(): List<UiMovie> = moviesRemoteSource.getPopularMovies().asUiMovie()
}
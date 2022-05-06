package com.ramirotorrejon.moviewscratch.features.movie.datasource.remote

import com.ramirotorrejon.moviewscratch.features.movie.datasource.MoviesSource
import javax.inject.Inject

class MoviesRemoteSourceImpl @Inject constructor(private val moviesService: MoviesService): MoviesSource.Remote {
	override suspend fun getPopularMovies(): List<MovieDTO> {
		return moviesService.getPopularMovies().results
	}

}
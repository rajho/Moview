package com.ramirotorrejon.moviewscratch.features.movie.datasource

import com.ramirotorrejon.moviewscratch.features.movie.datasource.remote.MovieDTO

interface MoviesSource {
	interface Local {

	}

	interface Remote {
		suspend fun getPopularMovies(): List<MovieDTO>
	}
}
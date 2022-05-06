package com.ramirotorrejon.moviewscratch.features.movie.datasource

import com.ramirotorrejon.moviewscratch.features.movie.uimovieslist.UiMovie

interface MoviesRepository {
	suspend fun getPopularMovies(): List<UiMovie>
}
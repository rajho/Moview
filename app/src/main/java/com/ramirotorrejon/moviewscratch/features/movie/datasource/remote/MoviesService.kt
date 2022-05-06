package com.ramirotorrejon.moviewscratch.features.movie.datasource.remote

import retrofit2.http.GET

interface MoviesService {

	@GET("movie/popular")
	suspend fun getPopularMovies(): MoviesResponse
}
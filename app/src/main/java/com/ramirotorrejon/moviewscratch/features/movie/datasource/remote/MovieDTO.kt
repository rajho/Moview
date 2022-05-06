package com.ramirotorrejon.moviewscratch.features.movie.datasource.remote

import com.ramirotorrejon.moviewscratch.features.movie.uimovieslist.UiMovie
import com.squareup.moshi.Json

data class MovieDTO(
	val id: String,
	val title: String,
	@Json(name = "release_date")
	val releaseDate: String,
	@Json(name = "poster_path")
	val imagePath: String,
	@Json(name = "overview")
	val plotSynopsis: String
)

fun MovieDTO.asUiMovie(): UiMovie {
	return UiMovie(
		id = id,
		title = title,
		releaseDate = releaseDate,
		imagePath = imagePath,
		plotSynopsis = plotSynopsis
	)
}

fun List<MovieDTO>.asUiMovie(): List<UiMovie> {
	return map { it.asUiMovie() }
}

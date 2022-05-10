package com.ramirotorrejon.moviewscratch.features.movie.uimovieslist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiMovie(
	val id: String,
	val title: String,
	val releaseDate: String,
	val imagePath: String,
	val plotSynopsis: String
): Parcelable
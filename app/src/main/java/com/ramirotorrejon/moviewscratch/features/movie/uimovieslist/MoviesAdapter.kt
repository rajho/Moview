package com.ramirotorrejon.moviewscratch.features.movie.uimovieslist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class MoviesAdapter : ListAdapter<UiMovie, MoviesViewHolder>(UiMovieDiffCallback()) {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
		return MoviesViewHolder.from(parent)
	}

	override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
		val item = getItem(position)
		holder.bind(item)
	}

}

class UiMovieDiffCallback : DiffUtil.ItemCallback<UiMovie>() {
	override fun areItemsTheSame(oldItem: UiMovie, newItem: UiMovie): Boolean {
		return oldItem.id == newItem.id
	}

	override fun areContentsTheSame(oldItem: UiMovie, newItem: UiMovie): Boolean {
		return oldItem == newItem
	}
}
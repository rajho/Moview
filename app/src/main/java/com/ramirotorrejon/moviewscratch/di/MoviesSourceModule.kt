package com.ramirotorrejon.moviewscratch.di

import com.ramirotorrejon.moviewscratch.features.movie.datasource.MoviesRepository
import com.ramirotorrejon.moviewscratch.features.movie.datasource.MoviesRepositoryImpl
import com.ramirotorrejon.moviewscratch.features.movie.datasource.MoviesSource
import com.ramirotorrejon.moviewscratch.features.movie.datasource.local.MoviesLocalSourceImpl
import com.ramirotorrejon.moviewscratch.features.movie.datasource.remote.MoviesRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesSourceModule {

	@Singleton
	@Binds
	abstract fun bindRepository(impl: MoviesRepositoryImpl): MoviesRepository


	@Binds
	abstract fun bindLocalDataSource(impl: MoviesLocalSourceImpl): MoviesSource.Local


	@Binds
	abstract fun bindRemoteDataSource(impl: MoviesRemoteSourceImpl): MoviesSource.Remote
}
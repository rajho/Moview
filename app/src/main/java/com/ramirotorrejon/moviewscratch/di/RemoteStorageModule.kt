package com.ramirotorrejon.moviewscratch.di

import com.ramirotorrejon.moviewscratch.features.movie.datasource.remote.interceptors.ApiKeyInterceptor
import com.ramirotorrejon.moviewscratch.features.movie.datasource.remote.MoviesService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteStorageModule {
	private const val BASE_URL = "https://api.themoviedb.org/3/"

	@Provides
	fun provideOkHttpClient(): OkHttpClient {
		val apiKeyInterceptor = ApiKeyInterceptor()
		val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Timber.i(message) }.apply { level = HttpLoggingInterceptor.Level.BODY }

		return OkHttpClient().newBuilder()
			.addInterceptor(httpLoggingInterceptor)
			.addInterceptor(apiKeyInterceptor)
			.build()
	}

	@Provides
	fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
		val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

		return Retrofit.Builder()
			.client(okHttpClient)
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.baseUrl(BASE_URL)
			.build()
	}

	@Provides
	@Singleton
	fun provideApiService(retrofit: Retrofit) = retrofit.create(MoviesService::class.java)
}
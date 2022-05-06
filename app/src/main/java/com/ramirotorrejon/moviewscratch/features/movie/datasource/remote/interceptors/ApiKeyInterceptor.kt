package com.ramirotorrejon.moviewscratch.features.movie.datasource.remote.interceptors

import com.ramirotorrejon.moviewscratch.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
		val originalRequest = chain.request()
		val newHttpUrl = originalRequest
			.url
			.newBuilder()
			.addQueryParameter("api_key", BuildConfig.API_KEY)
			.build()

		val newRequest = originalRequest
			.newBuilder()
			.url(newHttpUrl)
			.build()
		return chain.proceed(newRequest)

	}
}
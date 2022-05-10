package com.ramirotorrejon.moviewscratch.utils

import android.net.Uri
import java.net.MalformedURLException
import java.net.URL

const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
const val IMAGE_SIZE = "w185"

class ImageUtils {

	companion object {

		@JvmStatic
		fun buildImageURL(path: String?): URL? {
			val buildUri =
				Uri.parse(IMAGE_BASE_URL)
					.buildUpon()
					.appendPath(IMAGE_SIZE)
					.appendPath(path)
					.build()
			var url: URL? = null
			try {
				url = URL(buildUri.toString())
			} catch (e: MalformedURLException) {
				e.printStackTrace()
			}
			return url
		}
	}

}
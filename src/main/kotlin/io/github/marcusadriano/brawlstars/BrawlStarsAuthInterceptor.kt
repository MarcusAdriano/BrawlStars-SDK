package io.github.marcusadriano.brawlstars

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

internal class BrawlStarsAuthInterceptor(val token: BrawlStarsToken) : Interceptor {

    companion object {
        const val AUTHORIZATION = "Authorization"
    }


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newRequest = Request.Builder()
            .addHeader(AUTHORIZATION, "Bearer ${token.bearer}")
            .get()
            .url(request.url())
            .build()

        return chain.proceed(newRequest)
    }
}
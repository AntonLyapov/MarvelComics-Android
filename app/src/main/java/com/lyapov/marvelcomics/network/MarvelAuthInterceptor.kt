package com.lyapov.marvelcomics.network

import com.lyapov.marvelcomics.di.module.NetworkModule
import com.lyapov.marvelcomics.util.md5
import okhttp3.Interceptor
import okhttp3.Response

class MarvelAuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val timestamp = System.currentTimeMillis()
        val authString = "$timestamp${NetworkModule.MARVEL_PRIVATE_API_KEY}${NetworkModule.MARVEL_PUBLIC_API_KEY}"

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("ts", timestamp.toString())
            .addQueryParameter("apikey", NetworkModule.MARVEL_PUBLIC_API_KEY)
            .addQueryParameter("hash", authString.md5())
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}
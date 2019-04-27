package com.lyapov.marvelcomics.di.module

import com.lyapov.marvelcomics.network.MarvelApiService
import com.lyapov.marvelcomics.network.interceptors.MarvelAuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.GsonBuilder
import com.lyapov.marvelcomics.util.DateSerializer
import java.util.*


/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
class NetworkModule {

    companion object {
        const val MARVEL_BASE_URL = "https://gateway.marvel.com:443/"
        const val MARVEL_PUBLIC_API_KEY = "8bf61f3a29c9384471be1b7e91e6c6ec"
        const val MARVEL_PRIVATE_API_KEY = "11cfbb2bd1ba032c1038d4ecaebeb37ff2a5370a"
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gsonBuilder = GsonBuilder()
        gsonBuilder
            .registerTypeAdapter(Date::class.java, DateSerializer())

        val gsonConverterFactory = GsonConverterFactory.create(gsonBuilder.create())

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(MARVEL_BASE_URL)

        retrofitBuilder.client(okHttpClient)

        return retrofitBuilder.build()
    }

    @Singleton
    @Provides
    fun provideMarvelApi(retrofit: Retrofit): MarvelApiService {
        return retrofit.create(MarvelApiService::class.java)
    }

    @Provides
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, marvelAuthInterceptor: MarvelAuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(marvelAuthInterceptor)
            .build()
    }

    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun getMarvelAuthInterceptor(): MarvelAuthInterceptor {
        return MarvelAuthInterceptor()
    }
}
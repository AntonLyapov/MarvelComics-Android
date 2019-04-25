package com.lyapov.marvelcomics.di.module

import com.lyapov.marvelcomics.api.MarvelApiService
import com.lyapov.marvelcomics.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.MARVEL_BASE_URL)

//        val client = OkHttpClient.Builder()
//
//        if (BuildConfig.DEBUG) {
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//            client.addInterceptor(interceptor)
//        }

//        val okHttpClient = client.build()
        retrofitBuilder.client(okHttpClient)

        return retrofitBuilder.build()
    }

    @Provides
    internal fun provideMarvelApi(retrofit: Retrofit): MarvelApiService {
        return retrofit.create(MarvelApiService::class.java)
    }

    @Provides
    fun getOkHttpCleint(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}
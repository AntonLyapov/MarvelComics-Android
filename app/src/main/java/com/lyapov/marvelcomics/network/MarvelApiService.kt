package com.lyapov.marvelcomics.network

import com.lyapov.marvelcomics.network.response.ComicsRespone
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
interface MarvelApiService {
    @GET("v1/public/comics")
    fun getComics(
        @Query("format") format: String
    ): Single<ComicsRespone>
}
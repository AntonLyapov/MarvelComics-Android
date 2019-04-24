package com.lyapov.marvelcomics.api

import com.lyapov.marvelcomics.models.Comic
import com.lyapov.marvelcomics.util.Constants
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
interface MarvelApiService {
    @GET("v1/public/comics")
    fun getComics(): Call<List<Comic>>
}
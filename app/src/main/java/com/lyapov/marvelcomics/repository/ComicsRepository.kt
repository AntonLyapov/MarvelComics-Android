package com.lyapov.marvelcomics.repository

import com.lyapov.marvelcomics.network.MarvelApiService
import com.lyapov.marvelcomics.network.response.ComicsRespone
import io.reactivex.Single
import javax.inject.Inject

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsRepository @Inject constructor(private val api: MarvelApiService, private val database: AppDatabase) {

    fun getComics(): Single<ComicsRespone> {
        return api.getComics("comic")
    }
}
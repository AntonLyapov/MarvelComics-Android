package com.lyapov.marvelcomics.network

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
class ComicsRepository @Inject constructor(private val api: MarvelApiService) {

    fun getComics(): Single<ComicsRespone> {
        return api.getComics("comic")
    }
}
package com.lyapov.marvelcomics.api

import com.lyapov.marvelcomics.models.Comic
import io.reactivex.Single
import javax.inject.Inject

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                     1st Online Solutions                     *
 *  *  *               http://www.1stonlinesolutions.bg               *
 *  *  *          Copyright by 1st Online Solutions, 04 2019           *
 *  *  ****************************************************************
 */
class ComicsRepository @Inject constructor(private val api: MarvelApiService) {

    fun getComics(): Single<ArrayList<Comic>> {
        return api.getComics()
    }
}
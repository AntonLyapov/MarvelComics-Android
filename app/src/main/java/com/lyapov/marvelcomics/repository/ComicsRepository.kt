package com.lyapov.marvelcomics.repository

import com.google.gson.JsonSyntaxException
import com.lyapov.marvelcomics.interactors.DatabaseInteractor
import com.lyapov.marvelcomics.interactors.MemoryInteractor
import com.lyapov.marvelcomics.interactors.NetworkInteractor
import com.lyapov.marvelcomics.network.MarvelApiService
import com.lyapov.marvelcomics.network.models.ComicsRespone
import com.lyapov.marvelcomics.persistance.AppDatabase
import com.lyapov.marvelcomics.persistance.models.Comic
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import javax.inject.Inject

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsRepository @Inject constructor(
    private val memoryInteractor: MemoryInteractor,
    private val databaseInteractor: DatabaseInteractor,
    private val networkInteractor: NetworkInteractor
) {

    private var dataProviderDisposable: Disposable? = null

    fun getComics(): Observable<ArrayList<Comic>> {
        //return api.getComics("comic")

        val memoryObservable = memoryInteractor.getComics().toObservable()
        val databaseObservable = databaseInteractor.getComics().toObservable()
        val networkObservable = networkInteractor.getComics().toObservable()

        if (!isNetworkInProgress()) {
            dataProviderDisposable =
                Observable.concat<List<Comic>>(memoryObservable, databaseObservable, networkObservable)
                    .firstElement()
                    .subscribe({

                    }, {
                        handleNonHttpException(it)
                    })
        }

        return memoryInteractor.getComicsObservable()
    }

    private fun isNetworkInProgress(): Boolean {
        return dataProviderDisposable != null && !(dataProviderDisposable?.isDisposed ?: false)
    }

    private fun handleNonHttpException(throwable: Throwable) {
        // if not an HttpException throw further
        if (throwable is HttpException) {

        } else if (throwable is JsonSyntaxException) {

        } else if (throwable is SocketTimeoutException) {

        } else if (throwable is ConnectException) {

        } else {
            throw RuntimeException(throwable)
        }
    }
}
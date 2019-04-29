package com.lyapov.marvelcomics.repositories

import com.google.gson.JsonSyntaxException
import com.lyapov.marvelcomics.interactors.DatabaseInteractor
import com.lyapov.marvelcomics.interactors.MemoryInteractor
import com.lyapov.marvelcomics.interactors.NetworkInteractor
import com.lyapov.marvelcomics.persistance.models.Comic
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
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

    fun getComics(): Observable<List<Comic>> {
        val memoryObservable = memoryInteractor.getComics().toObservable()
        val databaseObservable = databaseInteractor.getComics().toObservable()
        val networkObservable = networkInteractor.getComics().toObservable()

        if (!isNetworkInProgress()) {
            dataProviderDisposable =
                Observable.concat<List<Comic>>(memoryObservable, databaseObservable, networkObservable)
                    .firstElement()
                    .subscribe({

                    }, { t ->
                        handleNonHttpException(t)
                    })
        }

        return memoryInteractor.getComicsObservable()
    }

    fun getForceComics() {
        if (isNetworkInProgress()) {
            dataProviderDisposable?.dispose()
        }

        val networkObservable = networkInteractor.getComics().toObservable()

        dataProviderDisposable = networkObservable
            .subscribe({

            }, { t ->
                handleNonHttpException(t)
            })
    }

    private fun isNetworkInProgress(): Boolean {
        return dataProviderDisposable != null && !(dataProviderDisposable?.isDisposed ?: false)
    }

    /**
     * If Throwable is not an http exception throw runtime exception
     */
    private fun handleNonHttpException(throwable: Throwable) {
        // if not an HttpException throw further
        when (throwable) {
            is HttpException -> {

            }
            is JsonSyntaxException -> {

            }
            is SocketTimeoutException -> {

            }
            is ConnectException -> {

            }
            is UnknownHostException -> {

            }
            else -> throw RuntimeException(throwable)
        }
    }
}
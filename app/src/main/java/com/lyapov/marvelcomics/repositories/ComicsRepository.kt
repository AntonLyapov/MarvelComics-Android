package com.lyapov.marvelcomics.repositories

import android.util.Log
import com.lyapov.marvelcomics.interactors.DatabaseInteractor
import com.lyapov.marvelcomics.interactors.MemoryInteractor
import com.lyapov.marvelcomics.interactors.NetworkInteractor
import com.lyapov.marvelcomics.persistance.models.Comic
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
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
                    .subscribe()
        }

        return memoryInteractor.getComicsObservable()
    }

    fun getForceComics(): Observable<List<Comic>> {
        if (isNetworkInProgress()) {
            dataProviderDisposable?.dispose()
        }

        val networkObservable = networkInteractor.getComics().toObservable()

        dataProviderDisposable = networkObservable
            .subscribe()

        return memoryInteractor.getComicsObservable()
    }

    private fun isNetworkInProgress(): Boolean {
        return dataProviderDisposable != null && !(dataProviderDisposable?.isDisposed ?: false)
    }
}
package com.lyapov.marvelcomics.interactors

import com.lyapov.marvelcomics.network.MarvelApiService
import com.lyapov.marvelcomics.persistance.models.Comic
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NetworkInteractor @Inject constructor(
    private val apiService: MarvelApiService,
    private val memoryInteractor: MemoryInteractor,
    private val databaseInteractor: DatabaseInteractor
) {

    fun getComics(): Single<ArrayList<Comic>?> {
        return apiService.getComics("comic")
            .subscribeOn(Schedulers.io())
            .map {
                it.data?.results
            }
            .doOnSuccess { comics ->
                comics?.let {
                    databaseInteractor.saveData(it)
                }
            }
            .doOnSuccess { comics ->
                comics?.let {
                    memoryInteractor.saveData(it)
                }
            }
            .doOnError { t ->
                memoryInteractor.onErrorReceived(t)
            }
    }
}
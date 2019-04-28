package com.lyapov.marvelcomics.interactors

import com.lyapov.marvelcomics.persistance.AppDatabase
import com.lyapov.marvelcomics.persistance.models.Comic
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DatabaseInteractor @Inject constructor(
    private val database: AppDatabase,
    private val memoryInteractor: MemoryInteractor
) {

    fun getComics(): Maybe<List<Comic>?> {
        return database.comicDao().getAll()
            .subscribeOn(Schedulers.io())
            .filter {
                it.isNotEmpty()
            }
            .doOnSuccess {
                memoryInteractor.saveData(it)
            }
    }

    fun saveData(comics: ArrayList<Comic>) {
        database.comicDao().deleteAll()
        database.comicDao().insertAll(comics)
    }
}
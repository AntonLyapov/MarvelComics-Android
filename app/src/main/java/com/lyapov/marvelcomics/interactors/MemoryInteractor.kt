package com.lyapov.marvelcomics.interactors

import com.lyapov.marvelcomics.persistance.models.Comic
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MemoryInteractor @Inject constructor() {

    private val observable by lazy {
        BehaviorSubject.create<List<Comic>>()
    }

    private var comics: List<Comic>? = null

    fun saveData(comics: List<Comic>) {
        this.comics = comics
        observable.onNext(comics)
    }

    fun getComics(): Maybe<List<Comic>> {
        return if (comics == null) Maybe.empty<List<Comic>>() else Maybe.just<List<Comic>>(comics)
    }

    fun getComicsObservable(): Observable<List<Comic>> {
        return observable
    }
}
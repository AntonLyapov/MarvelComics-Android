package com.lyapov.marvelcomics.interactors

import com.lyapov.marvelcomics.persistance.models.Comic
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MemoryInteractor @Inject constructor() {
    private var observable: BehaviorSubject<ArrayList<Comic>> = BehaviorSubject.create<ArrayList<Comic>>()
    private var comics: ArrayList<Comic>? = null

    fun saveData(comics: ArrayList<Comic>) {
        this.comics = comics
        observable.onNext(comics)
    }

    fun getComics(): Maybe<ArrayList<Comic>> {
        return if (comics == null) Maybe.empty<ArrayList<Comic>>() else Maybe.just<ArrayList<Comic>>(comics)
    }

    fun getComicsObservable(): Observable<ArrayList<Comic>> {
        return observable
    }
}
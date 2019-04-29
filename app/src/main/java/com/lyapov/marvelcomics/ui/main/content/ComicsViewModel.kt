package com.lyapov.marvelcomics.ui.main.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lyapov.marvelcomics.persistance.models.Comic
import com.lyapov.marvelcomics.repositories.ComicsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsViewModel @Inject constructor(private val comicsRepository: ComicsRepository) : ViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    private val comics = MutableLiveData<List<Comic>?>()
    private val requestError = MutableLiveData<String?>()
    private val loading = MutableLiveData<Boolean>()

    init {
        fetchComics()
    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }

    fun getComics(): LiveData<List<Comic>?> {
        return comics
    }

    fun getRequestError(): LiveData<String?> {
        return requestError
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    fun fetchComics() {
        loading.value = true

        disposable.add(
            comicsRepository.getComics()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ c ->
                    onComicsReceivedSuccessfully(c)
                }, { t ->
                    onComicsReceivedWithError(t)
                })
        )
    }

    fun forceFetchComics() {
        loading.value = true

        comicsRepository.getForceComics()
    }

    private fun onComicsReceivedSuccessfully(c: List<Comic>) {
        comics.value = c

        requestError.value = null
        loading.value = false
    }

    private fun onComicsReceivedWithError(t: Throwable) {
        comics.value = null

        requestError.value = t.localizedMessage
        loading.value = false
    }
}
package com.lyapov.marvelcomics.ui.main.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.lyapov.marvelcomics.api.MarvelApiService
import io.reactivex.disposables.CompositeDisposable
import androidx.lifecycle.MutableLiveData
import com.lyapov.marvelcomics.models.Comic
import javax.inject.Inject
import androidx.lifecycle.LiveData
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers


class ComicsViewModel @Inject constructor(private val marvelApiService: MarvelApiService): ViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    private val repos = MutableLiveData<List<Comic>>()
    private val repoLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()

    init {
        fetchRepos()
    }

    fun getRepos(): LiveData<List<Comic>> {
        return repos
    }

    fun getError(): LiveData<Boolean> {
        return repoLoadError
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    private fun fetchRepos() {
        loading.value = true

        disposable.add(
            marvelApiService.getComics().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object : DisposableSingleObserver<List<Comic>>() {
                override fun onSuccess(value: List<Comic>) {
                    repoLoadError.value = false
                    repos.value = value
                    loading.value = false
                }

                override fun onError(e: Throwable) {
                    repoLoadError.value = true
                    loading.value = false
                }
            })
        )
    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}
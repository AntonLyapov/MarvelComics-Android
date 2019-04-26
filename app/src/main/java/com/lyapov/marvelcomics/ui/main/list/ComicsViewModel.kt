package com.lyapov.marvelcomics.ui.main.list

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import androidx.lifecycle.MutableLiveData
import com.lyapov.marvelcomics.models.Comic
import javax.inject.Inject
import androidx.lifecycle.LiveData
import com.lyapov.marvelcomics.api.ComicsRepository
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Retrofit


class ComicsViewModel @Inject constructor(
    private val retrofit: Retrofit,
    private val comicsRepository: ComicsRepository): ViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    private val comics = MutableLiveData<ArrayList<Comic>?>()
    private val requestError = MutableLiveData<String?>()
    private val loading = MutableLiveData<Boolean>()

    init {
        fetchComics()
    }

    fun getComics(): LiveData<ArrayList<Comic>?> {
        return comics
    }

    fun getRequestError(): LiveData<String?> {
        return requestError
    }

    fun getLoading(): LiveData<Boolean> {
        return loading
    }

    private fun fetchComics() {
        loading.value = true

        disposable.add(
            comicsRepository.getComics().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object : DisposableSingleObserver<ArrayList<Comic>>() {
                override fun onSuccess(value: ArrayList<Comic>) {
                    comics.value = value

                    requestError.value = null
                    loading.value = false
                }

                override fun onError(e: Throwable) {
                    comics.value = null

                    requestError.value = e.localizedMessage
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
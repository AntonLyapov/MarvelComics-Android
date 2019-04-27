package com.lyapov.marvelcomics.ui.main.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lyapov.marvelcomics.persistance.models.Comic
import com.lyapov.marvelcomics.repository.ComicsRepository
import com.lyapov.marvelcomics.network.models.ComicsRespone
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsViewModel @Inject constructor(
    private val comicsRepository: ComicsRepository
) : ViewModel() {

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

    fun fetchComics() {
        loading.value = true

        disposable.add(
            comicsRepository.getComics()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ArrayList<Comic>>() {
                    override fun onSuccess(t: ArrayList<Comic>) {
                        comics.value = t

                        requestError.value = null
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
        )

//        disposable.add(
//            comicsRepository.getComics().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :
//                    DisposableSingleObserver<ComicsRespone>() {
//                    override fun onSuccess(value: ComicsRespone) {
//                        comics.value = value.data?.results
//
//                        requestError.value = null
//                        loading.value = false
//                    }
//
//                    override fun onError(e: Throwable) {
//                        comics.value = null
//
//                        requestError.value = e.localizedMessage
//                        loading.value = false
//                    }
//                })
//        )
    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}
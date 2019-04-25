package com.lyapov.marvelcomics.di.factory

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModelProvider
import javax.inject.Singleton
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Provider


@Singleton
class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {

    @NonNull
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]

        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }

        try {
            return creator.get() as T
        } catch (ex: Exception) {
            throw RuntimeException(ex)
        }

    }
}
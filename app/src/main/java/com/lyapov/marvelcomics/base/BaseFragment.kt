package com.lyapov.marvelcomics.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.lyapov.marvelcomics.di.factory.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
abstract class BaseFragment<VM : ViewModel>: DaggerFragment() {

    protected val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(getViewModelClass())
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @LayoutRes
    abstract fun layoutResId(): Int

    @NonNull
    abstract fun getViewModelClass(): Class<VM>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId(), container, false);
    }
}
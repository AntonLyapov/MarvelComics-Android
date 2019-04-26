package com.lyapov.marvelcomics.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lyapov.marvelcomics.di.factory.ViewModelFactory
import com.lyapov.marvelcomics.di.factory.ViewModelKey
import com.lyapov.marvelcomics.ui.main.details.DetailsViewModel
import com.lyapov.marvelcomics.ui.main.list.ComicsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ComicsViewModel::class)
    abstract fun bindComicsViewModel(viewModel: ComicsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel
}
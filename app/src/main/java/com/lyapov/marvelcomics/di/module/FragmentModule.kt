package com.lyapov.marvelcomics.di.module

import com.lyapov.marvelcomics.ui.details.content.DetailsFragment
import com.lyapov.marvelcomics.ui.main.content.ComicsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun provideComicsFragment(): ComicsFragment

    @ContributesAndroidInjector
    abstract fun provideDetailsFragment(): DetailsFragment
}
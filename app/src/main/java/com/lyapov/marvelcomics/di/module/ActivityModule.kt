package com.lyapov.marvelcomics.di.module

import dagger.Module
import com.lyapov.marvelcomics.ui.main.MainActivity
import dagger.android.ContributesAndroidInjector

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
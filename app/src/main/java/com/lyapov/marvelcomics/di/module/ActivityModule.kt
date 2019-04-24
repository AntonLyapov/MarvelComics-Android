package com.lyapov.marvelcomics.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

//    @Provides
//    fun providePresenter(): MainContract.Presenter {
//        return MainPresenter()
//    }

}
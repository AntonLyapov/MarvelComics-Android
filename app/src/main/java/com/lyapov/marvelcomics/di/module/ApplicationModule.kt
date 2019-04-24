package com.lyapov.marvelcomics.di.module

import android.app.Application
import com.lyapov.marvelcomics.MarvelApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
class ApplicationModule(private val application: MarvelApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }
}
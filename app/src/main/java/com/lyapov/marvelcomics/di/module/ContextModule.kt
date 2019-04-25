package com.lyapov.marvelcomics.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Binds



/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module
abstract class ContextModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}
package com.lyapov.marvelcomics.di.module

import android.content.Context
import com.lyapov.marvelcomics.di.qualifiers.ApplicationContext
import com.lyapov.marvelcomics.di.scopes.ApplicationScope
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
class ContextModule(private val context: Context) {

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun provideContext(): Context {
        return context
    }
}
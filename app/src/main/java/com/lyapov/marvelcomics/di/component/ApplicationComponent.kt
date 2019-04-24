package com.lyapov.marvelcomics.di.component

import android.content.Context
import com.lyapov.marvelcomics.MarvelApplication
import com.lyapov.marvelcomics.di.module.ApplicationModule
import com.lyapov.marvelcomics.di.module.ContextModule
import dagger.Component
import com.lyapov.marvelcomics.di.qualifiers.ApplicationContext



/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Component(modules = [
//    ContextModule::class,
    ApplicationModule::class
])
interface ApplicationComponent {

//    @ApplicationContext
//    fun getContext(): Context

    fun inject(application: MarvelApplication)
}
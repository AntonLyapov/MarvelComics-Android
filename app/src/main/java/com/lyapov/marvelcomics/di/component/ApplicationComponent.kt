package com.lyapov.marvelcomics.di.component

import android.app.Application
import com.lyapov.marvelcomics.MarvelApplication
import com.lyapov.marvelcomics.di.module.*
import dagger.Component
import javax.inject.Singleton
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule


/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ContextModule::class,
        ActivityModule::class,
        FragmentModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: MarvelApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
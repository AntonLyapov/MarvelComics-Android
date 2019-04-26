package com.lyapov.marvelcomics.di.component

import android.app.Application
import com.lyapov.marvelcomics.MarvelApplication
import com.lyapov.marvelcomics.di.module.ActivityModule
import com.lyapov.marvelcomics.di.module.ApplicationModule
import com.lyapov.marvelcomics.di.module.ContextModule
import com.lyapov.marvelcomics.di.module.FragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


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
package com.lyapov.marvelcomics.di.module

import com.lyapov.marvelcomics.network.ComicsRepository
import com.lyapov.marvelcomics.network.MarvelApiService
import dagger.Module
import dagger.Provides

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class
    ]
)
class ApplicationModule {

    @Provides
    fun provideComicsRepository(api: MarvelApiService): ComicsRepository =
        ComicsRepository(api)
}
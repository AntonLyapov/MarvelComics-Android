package com.lyapov.marvelcomics.di.module

import com.lyapov.marvelcomics.interactors.DatabaseInteractor
import com.lyapov.marvelcomics.interactors.MemoryInteractor
import com.lyapov.marvelcomics.interactors.NetworkInteractor
import com.lyapov.marvelcomics.repository.ComicsRepository
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
    fun provideComicsRepository(memoryInteractor: MemoryInteractor, databaseInteractor: DatabaseInteractor, networkInteractor: NetworkInteractor): ComicsRepository =
        ComicsRepository(memoryInteractor, databaseInteractor, networkInteractor)
}
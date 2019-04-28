package com.lyapov.marvelcomics.di.module

import com.lyapov.marvelcomics.interactors.DatabaseInteractor
import com.lyapov.marvelcomics.interactors.MemoryInteractor
import com.lyapov.marvelcomics.interactors.NetworkInteractor
import com.lyapov.marvelcomics.network.MarvelApiService
import com.lyapov.marvelcomics.persistance.AppDatabase
import com.lyapov.marvelcomics.repositories.ComicsRepository
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
class RepositoryModule {

    @Provides
    @Singleton
    fun provideComicsMemory(): MemoryInteractor {
        return MemoryInteractor()
    }

    @Provides
    @Singleton
    fun provideComicsDatabase(appDatabase: AppDatabase, memoryInteractor: MemoryInteractor): DatabaseInteractor {
        return DatabaseInteractor(appDatabase, memoryInteractor)
    }

    @Provides
    @Singleton
    fun provideComicsNetwork(apiService: MarvelApiService, memoryInteractor: MemoryInteractor, databaseInteractor: DatabaseInteractor): NetworkInteractor {
        return NetworkInteractor(apiService, memoryInteractor, databaseInteractor)
    }

    @Provides
    @Singleton
    fun provideComicsRepository(
        memoryInteractor: MemoryInteractor,
        databaseInteractor: DatabaseInteractor,
        networkInteractor: NetworkInteractor
    ): ComicsRepository {
        return ComicsRepository(memoryInteractor, databaseInteractor, networkInteractor)
    }
}
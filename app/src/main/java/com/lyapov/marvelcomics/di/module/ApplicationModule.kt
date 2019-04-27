package com.lyapov.marvelcomics.di.module

import android.content.Context
import androidx.room.Room
import com.lyapov.marvelcomics.interactors.DatabaseInteractor
import com.lyapov.marvelcomics.interactors.MemoryInteractor
import com.lyapov.marvelcomics.interactors.NetworkInteractor
import com.lyapov.marvelcomics.persistance.AppDatabase
import com.lyapov.marvelcomics.repository.ComicsRepository
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
@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class
    ]
)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "MarvelComics.db"
        )
            .build()
    }

    @Provides
    fun provideComicsRepository(
        memoryInteractor: MemoryInteractor,
        databaseInteractor: DatabaseInteractor,
        networkInteractor: NetworkInteractor
    ): ComicsRepository =
        ComicsRepository(memoryInteractor, databaseInteractor, networkInteractor)
}
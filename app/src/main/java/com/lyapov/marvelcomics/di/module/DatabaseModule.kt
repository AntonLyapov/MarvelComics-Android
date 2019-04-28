package com.lyapov.marvelcomics.di.module

import android.content.Context
import androidx.room.Room
import com.lyapov.marvelcomics.persistance.AppDatabase
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
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "MarvelComics.db"
        )
            .build()
    }
}
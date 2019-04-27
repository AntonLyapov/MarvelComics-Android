package com.lyapov.marvelcomics.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lyapov.marvelcomics.persistance.models.Comic
import com.lyapov.marvelcomics.persistance.models.ComicDao
import com.lyapov.marvelcomics.persistance.models.Image

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Database(
    entities = [
        Comic::class
    ],
    version = AppDatabase.VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comicDao(): ComicDao

    companion object {
        const val VERSION = 1
    }
}
package com.lyapov.marvelcomics.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lyapov.marvelcomics.persistance.converters.*
import com.lyapov.marvelcomics.persistance.models.Comic
import com.lyapov.marvelcomics.persistance.models.ComicDao
import com.lyapov.marvelcomics.persistance.models.summary.StorySummary

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
@TypeConverters(
    CharacterSummaryTypeConverter::class,
    CreatorSummaryTypeConverter::class,
    EventSummaryTypeConverter::class,
    StorySummaryTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comicDao(): ComicDao

    companion object {
        const val VERSION = 1
    }
}
package com.lyapov.marvelcomics.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lyapov.marvelcomics.data.Comic
import com.lyapov.marvelcomics.data.ComicDao

@Database(
    entities = [
        Comic::class
    ],
    version = AppDatabase.VERSION
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comicDao(): ComicDao

    companion object {
        const val VERSION = 1

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "MarvelComics.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
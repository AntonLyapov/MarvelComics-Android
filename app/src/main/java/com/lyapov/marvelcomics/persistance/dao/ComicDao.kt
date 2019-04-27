package com.lyapov.marvelcomics.persistance.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.Maybe



/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Dao
interface ComicDao {
    @Query("SELECT * from Comics")
    fun getAll(): Maybe<List<Comic>>

    @Insert(onConflict = REPLACE)
    fun insert(comic: Comic)

    @Insert(onConflict = REPLACE)
    fun insertAll(comics: ArrayList<Comic>)

    @Query("DELETE from Comics")
    fun deleteAll()
}
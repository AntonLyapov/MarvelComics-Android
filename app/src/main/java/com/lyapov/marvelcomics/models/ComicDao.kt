package com.lyapov.marvelcomics.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Dao
interface ComicDao {
    @Query("SELECT * from Comic")
    fun getAll(): List<Comic>

    @Insert(onConflict = REPLACE)
    fun insert(comic: Comic)

    @Query("DELETE from Comic")
    fun deleteAll()
}
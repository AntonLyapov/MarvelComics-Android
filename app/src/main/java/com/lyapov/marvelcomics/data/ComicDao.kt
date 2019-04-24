package com.lyapov.marvelcomics.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ComicDao {
    @Query("SELECT * from Comic")
    fun getAll(): List<Comic>

    @Insert(onConflict = REPLACE)
    fun insert(comic: Comic)

    @Query("DELETE from Comic")
    fun deleteAll()
}
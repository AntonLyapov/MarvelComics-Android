package com.lyapov.marvelcomics.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                     1st Online Solutions                     *
 *  *  *               http://www.1stonlinesolutions.bg               *
 *  *  *          Copyright by 1st Online Solutions, 04 2019           *
 *  *  ****************************************************************
 */
abstract class BaseDatabaseModel {
    @Expose
    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null
}
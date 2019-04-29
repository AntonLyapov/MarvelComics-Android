package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.ComicDate
import com.lyapov.marvelcomics.persistance.models.ComicPrice
import com.lyapov.marvelcomics.persistance.models.Image
import com.lyapov.marvelcomics.persistance.models.summary.StorySummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicDatesTypeConverter {
    @TypeConverter
    fun stringToArrayList(value: String?): ArrayList<ComicDate>? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<ComicDate>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun arrayListToString(value: ArrayList<ComicDate>?): String? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<ComicDate>>() {}.type
        return Gson().toJson(value, type)
    }
}
package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.summary.ComicSummary
import com.lyapov.marvelcomics.persistance.models.summary.StorySummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicSummariesTypeConverter {
    @TypeConverter
    fun stringToArrayList(value: String?): ArrayList<ComicSummary>? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<ComicSummary>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun arrayListToString(value: ArrayList<ComicSummary>?): String? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<ComicSummary>>() {}.type
        return Gson().toJson(value, type)
    }
}
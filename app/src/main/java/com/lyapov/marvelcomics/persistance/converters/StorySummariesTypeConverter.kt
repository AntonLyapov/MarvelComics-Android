package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.summary.StorySummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class StorySummariesTypeConverter {
    @TypeConverter
    fun stringToArrayList(value: String?): ArrayList<StorySummary>? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<StorySummary>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun arrayListToString(value: ArrayList<StorySummary>?): String? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<StorySummary>>() {}.type
        return Gson().toJson(value, type)
    }
}
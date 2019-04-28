package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.summary.EventSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class EventSummaryTypeConverter {
    @TypeConverter
    fun stringToArrayList(value: String?): ArrayList<EventSummary>? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<EventSummary>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun arrayListToString(value: ArrayList<EventSummary>?): String? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<EventSummary>>() {}.type
        return Gson().toJson(value, type)
    }
}
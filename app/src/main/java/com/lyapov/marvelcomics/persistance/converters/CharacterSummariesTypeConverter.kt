package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.summary.CharacterSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class CharacterSummariesTypeConverter {
    @TypeConverter
    fun stringToArrayList(value: String?): ArrayList<CharacterSummary>? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<CharacterSummary>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun arrayListToString(value: ArrayList<CharacterSummary>?): String? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<CharacterSummary>>() {}.type
        return Gson().toJson(value, type)
    }
}
package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.Image
import com.lyapov.marvelcomics.persistance.models.summary.StorySummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ImagesTypeConverter {
    @TypeConverter
    fun stringToArrayList(value: String?): ArrayList<Image>? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<Image>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun arrayListToString(value: ArrayList<Image>?): String? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<Image>>() {}.type
        return Gson().toJson(value, type)
    }
}
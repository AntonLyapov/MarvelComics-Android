package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.base.BaseDatabaseModel

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
open class BaseModelTypeConverter<T : BaseDatabaseModel> {
    @TypeConverter
    fun stringToArrayList(value: String?): ArrayList<T>? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<T>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun arrayListToString(value: ArrayList<T>?): String? {
        if (value == null) {
            return null
        }

        val type = object : TypeToken<ArrayList<T>>() {}.type
        return Gson().toJson(value, type)
    }
}
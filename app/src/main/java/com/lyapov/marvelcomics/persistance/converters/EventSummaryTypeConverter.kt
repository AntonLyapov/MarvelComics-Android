package com.lyapov.marvelcomics.persistance.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lyapov.marvelcomics.persistance.models.base.BaseDatabaseModel
import com.lyapov.marvelcomics.persistance.models.summary.EventSummary
import com.lyapov.marvelcomics.persistance.models.summary.StorySummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class EventSummaryTypeConverter: BaseModelTypeConverter<EventSummary>()
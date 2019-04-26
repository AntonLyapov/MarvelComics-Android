package com.lyapov.marvelcomics.models.summary

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class StorySummary: BaseSummary() {

    @Expose
    @SerializedName("type")
    val type: String? = null
}
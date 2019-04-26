package com.lyapov.marvelcomics.models.summary

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lyapov.marvelcomics.models.BaseDatabaseModel

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
open class BaseSummary: BaseDatabaseModel() {

    @Expose
    @SerializedName("resourceURI")
    var resourceURI: String? = null

    @Expose
    @SerializedName("name")
    var name: String? = null
}
package com.lyapov.marvelcomics.models.list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
open class BaseList<T> {

    @Expose
    @SerializedName("available")
    val available: Int? = null

    @Expose
    @SerializedName("returned")
    val returned: Int? = null

    @Expose
    @SerializedName("collectionURI")
    val collectionURI: String? = null

    @Expose
    @SerializedName("items")
    val items: Array<T>? = null
}
package com.lyapov.marvelcomics.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lyapov.marvelcomics.models.Comic

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsResponseData {

    @Expose
    @SerializedName("offset")
    val offset: Int? = null

    @Expose
    @SerializedName("limit")
    val limit: Int? = null

    @Expose
    @SerializedName("total")
    val total: Int? = null

    @Expose
    @SerializedName("count")
    val count: Int? = null

    @Expose
    @SerializedName("results")
    val results: ArrayList<Comic>? = null
}
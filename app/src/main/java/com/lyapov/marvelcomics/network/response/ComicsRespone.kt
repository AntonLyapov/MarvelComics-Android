package com.lyapov.marvelcomics.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsRespone {

    @Expose
    @SerializedName("code")
    val code: Int? = null

    @Expose
    @SerializedName("status")
    val status: String? = null

    @Expose
    @SerializedName("copyright")
    val copyright: String? = null

    @Expose
    @SerializedName("attributionText")
    val attributionText: String? = null

    @Expose
    @SerializedName("attributionHTML")
    val attributionHTML: String? = null

    @Expose
    @SerializedName("etag")
    val etag: String? = null

    @Expose
    @SerializedName("data")
    val data: ComicsResponseData? = null
}
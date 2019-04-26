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
open class BaseRoleSummary: BaseSummary() {

    @Expose
    @SerializedName("role")
    val role: String? = null
}
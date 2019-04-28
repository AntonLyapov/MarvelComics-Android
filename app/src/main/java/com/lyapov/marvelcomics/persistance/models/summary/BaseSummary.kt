package com.lyapov.marvelcomics.persistance.models.summary

import android.os.Parcel
import android.os.Parcelable
import com.lyapov.marvelcomics.persistance.models.base.BaseDatabaseModel

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
open class BaseSummary(
    var resourceURI: String? = null,
    var name: String? = null
) : BaseDatabaseModel() {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(resourceURI)
        parcel.writeString(name)
    }

    companion object CREATOR : Parcelable.Creator<BaseSummary> {
        override fun createFromParcel(parcel: Parcel): BaseSummary {
            return BaseSummary(parcel)
        }

        override fun newArray(size: Int): Array<BaseSummary?> {
            return arrayOfNulls(size)
        }
    }
}
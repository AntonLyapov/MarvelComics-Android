package com.lyapov.marvelcomics.persistance.models.summary

import android.os.Parcel
import android.os.Parcelable

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
open class BaseRoleSummary(
    resourceURI: String?,
    name: String?,
    var role: String?
): BaseSummary(resourceURI, name) {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeString(role)
    }

    companion object CREATOR : Parcelable.Creator<BaseRoleSummary> {
        override fun createFromParcel(parcel: Parcel): BaseRoleSummary {
            return BaseRoleSummary(parcel)
        }

        override fun newArray(size: Int): Array<BaseRoleSummary?> {
            return arrayOfNulls(size)
        }
    }
}
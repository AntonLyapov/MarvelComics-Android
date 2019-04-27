package com.lyapov.marvelcomics.models.summary

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "StorySummaries")
class StorySummary(
    resourceURI: String?,
    name: String?,
    val type: String? = null
): BaseSummary(resourceURI, name) {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeString(type)
    }

    companion object CREATOR : Parcelable.Creator<StorySummary> {
        override fun createFromParcel(parcel: Parcel): StorySummary {
            return StorySummary(parcel)
        }

        override fun newArray(size: Int): Array<StorySummary?> {
            return arrayOfNulls(size)
        }
    }
}
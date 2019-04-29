package com.lyapov.marvelcomics.persistance.models.summary

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
@Entity(tableName = "EventSummaries")
class CreatorSummary(
    resourceURI: String?,
    name: String?,
    role: String?
) : BaseRoleSummary(resourceURI, name, role) {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<CreatorSummary> {
        override fun createFromParcel(parcel: Parcel): CreatorSummary {
            return CreatorSummary(parcel)
        }

        override fun newArray(size: Int): Array<CreatorSummary?> {
            return arrayOfNulls(size)
        }
    }
}
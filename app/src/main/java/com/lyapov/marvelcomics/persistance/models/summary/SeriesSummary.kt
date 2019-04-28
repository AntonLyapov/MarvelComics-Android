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
@Entity(tableName = "SeriesSummaries")
class SeriesSummary(
    resourceURI: String?,
    name: String?
): BaseSummary(resourceURI, name) {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<SeriesSummary> {
        override fun createFromParcel(parcel: Parcel): SeriesSummary {
            return SeriesSummary(parcel)
        }

        override fun newArray(size: Int): Array<SeriesSummary?> {
            return arrayOfNulls(size)
        }
    }
}
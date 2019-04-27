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
@Entity(tableName = "ComicSummaries")
class ComicSummary(
    resourceURI: String?,
    name: String?
) : BaseSummary(resourceURI, name) {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<ComicSummary> {
        override fun createFromParcel(parcel: Parcel): ComicSummary {
            return ComicSummary(parcel)
        }

        override fun newArray(size: Int): Array<ComicSummary?> {
            return arrayOfNulls(size)
        }
    }
}
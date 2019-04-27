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
@Entity(tableName = "CharacterSummaries")
class CharacterSummary(
    resourceURI: String?,
    name: String?
) : BaseSummary(resourceURI, name) {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<CharacterSummary> {
        override fun createFromParcel(parcel: Parcel): CharacterSummary {
            return CharacterSummary(parcel)
        }

        override fun newArray(size: Int): Array<CharacterSummary?> {
            return arrayOfNulls(size)
        }
    }
}
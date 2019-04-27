package com.lyapov.marvelcomics.models.list

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.models.summary.CreatorSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "CreatorLists")
class CreatorList(
    available: Int?,
    returned: Int?,
    collectionURI: String?,
    val items: Array<CreatorSummary>? = null
): BaseList(available, returned, collectionURI) {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArray(CreatorSummary.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeParcelableArray(items, flags)
    }

    companion object CREATOR : Parcelable.Creator<CreatorList> {
        override fun createFromParcel(parcel: Parcel): CreatorList {
            return CreatorList(parcel)
        }

        override fun newArray(size: Int): Array<CreatorList?> {
            return arrayOfNulls(size)
        }
    }
}
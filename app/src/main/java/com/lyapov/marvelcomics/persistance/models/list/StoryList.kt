package com.lyapov.marvelcomics.persistance.models.list

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.persistance.models.summary.StorySummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "StoryLists")
class StoryList(
    available: Int?,
    returned: Int?,
    collectionURI: String?,
    val items: Array<StorySummary>? = null
): BaseList(available, returned, collectionURI) {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArray(StorySummary.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeParcelableArray(items, flags)
    }

    companion object CREATOR : Parcelable.Creator<StoryList> {
        override fun createFromParcel(parcel: Parcel): StoryList {
            return StoryList(parcel)
        }

        override fun newArray(size: Int): Array<StoryList?> {
            return arrayOfNulls(size)
        }
    }
}
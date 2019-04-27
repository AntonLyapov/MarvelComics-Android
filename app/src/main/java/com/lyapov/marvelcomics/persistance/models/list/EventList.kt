package com.lyapov.marvelcomics.persistance.models.list

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.persistance.models.summary.EventSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "EventLists")
class EventList(
    available: Int?,
    returned: Int?,
    collectionURI: String?,
    val items: Array<EventSummary>? = null
): BaseList(available, returned, collectionURI) {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArray(EventSummary.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeParcelableArray(items, flags)
    }

    companion object CREATOR : Parcelable.Creator<EventList> {
        override fun createFromParcel(parcel: Parcel): EventList {
            return EventList(parcel)
        }

        override fun newArray(size: Int): Array<EventList?> {
            return arrayOfNulls(size)
        }
    }
}
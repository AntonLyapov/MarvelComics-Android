package com.lyapov.marvelcomics.models.list

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.models.summary.CharacterSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "CharacterLists")
class CharacterList(
    available: Int?,
    returned: Int?,
    collectionURI: String?,
    val items: Array<CharacterSummary>? = null
): BaseList(available, returned, collectionURI) {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArray(CharacterSummary.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeParcelableArray(items, flags)
    }

    companion object CREATOR : Parcelable.Creator<CharacterList> {
        override fun createFromParcel(parcel: Parcel): CharacterList {
            return CharacterList(parcel)
        }

        override fun newArray(size: Int): Array<CharacterList?> {
            return arrayOfNulls(size)
        }
    }
}
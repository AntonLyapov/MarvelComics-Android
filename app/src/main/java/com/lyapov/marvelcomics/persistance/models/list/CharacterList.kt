package com.lyapov.marvelcomics.persistance.models.list

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.persistance.models.summary.CharacterSummary

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
    var items: ArrayList<CharacterSummary>? = null
): BaseList(available, returned, collectionURI) {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArrayList(CharacterSummary.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeTypedList(items)
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
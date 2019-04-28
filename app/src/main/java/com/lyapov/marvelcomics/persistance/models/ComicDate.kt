package com.lyapov.marvelcomics.persistance.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.persistance.models.base.BaseDatabaseModel
import java.util.*

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "ComicDates")
class ComicDate(
    val type: String? = null,
    val date: Date? = null
) : BaseDatabaseModel() {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readSerializable() as? Date
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeSerializable(date)
    }

    companion object CREATOR : Parcelable.Creator<ComicDate> {
        override fun createFromParcel(parcel: Parcel): ComicDate {
            return ComicDate(parcel)
        }

        override fun newArray(size: Int): Array<ComicDate?> {
            return arrayOfNulls(size)
        }
    }
}
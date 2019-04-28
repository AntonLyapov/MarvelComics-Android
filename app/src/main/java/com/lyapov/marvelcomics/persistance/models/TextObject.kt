package com.lyapov.marvelcomics.persistance.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.persistance.models.base.BaseDatabaseModel

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "TextObjects")
data class TextObject(
    val type: String? = null,
    val language: String? = null,
    val text: String? = null
) : BaseDatabaseModel() {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(language)
        parcel.writeString(text)
    }

    companion object CREATOR : Parcelable.Creator<TextObject> {
        override fun createFromParcel(parcel: Parcel): TextObject {
            return TextObject(parcel)
        }

        override fun newArray(size: Int): Array<TextObject?> {
            return arrayOfNulls(size)
        }
    }
}
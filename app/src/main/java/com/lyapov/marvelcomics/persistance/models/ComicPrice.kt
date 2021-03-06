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
@Entity(tableName = "ComicPrices")
data class ComicPrice(
    val type: String? = null,
    val price: Double? = null
) : BaseDatabaseModel() {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeDouble(price ?: 0.0)
    }

    companion object CREATOR : Parcelable.Creator<ComicPrice> {
        override fun createFromParcel(parcel: Parcel): ComicPrice {
            return ComicPrice(parcel)
        }

        override fun newArray(size: Int): Array<ComicPrice?> {
            return arrayOfNulls(size)
        }
    }
}
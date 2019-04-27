package com.lyapov.marvelcomics.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.lyapov.marvelcomics.models.base.BaseParcelableModel

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
    val price: Float? = null
) : BaseParcelableModel() {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeFloat(price ?: 0f)
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
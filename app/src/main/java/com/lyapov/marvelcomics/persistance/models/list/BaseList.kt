package com.lyapov.marvelcomics.persistance.models.list

import android.os.Parcel
import android.os.Parcelable
import com.lyapov.marvelcomics.persistance.models.base.BaseDatabaseModel
import com.lyapov.marvelcomics.persistance.models.summary.BaseRoleSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
open class BaseList(
    val available: Int? = null,
    val returned: Int? = null,
    val collectionURI: String? = null
) : BaseDatabaseModel() {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(available ?: 0)
        parcel.writeInt(returned ?: 0)
        parcel.writeString(collectionURI)
    }

    companion object CREATOR : Parcelable.Creator<BaseRoleSummary> {
        override fun createFromParcel(parcel: Parcel): BaseRoleSummary {
            return BaseRoleSummary(parcel)
        }

        override fun newArray(size: Int): Array<BaseRoleSummary?> {
            return arrayOfNulls(size)
        }
    }
}
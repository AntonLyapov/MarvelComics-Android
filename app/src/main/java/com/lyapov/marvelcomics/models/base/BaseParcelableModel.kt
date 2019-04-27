package com.lyapov.marvelcomics.models.base

import android.os.Parcelable
import androidx.room.PrimaryKey

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
abstract class BaseParcelableModel: Parcelable {

    @PrimaryKey(autoGenerate = true)
    var localId: Int? = null

    override fun describeContents(): Int {
        return 0
    }
}
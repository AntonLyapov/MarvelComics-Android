package com.lyapov.marvelcomics.models.summary

import androidx.room.Entity
import androidx.room.ForeignKey
import com.lyapov.marvelcomics.models.Comic

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(
    tableName = "TextObjects",
    foreignKeys = [
        ForeignKey(
            entity = Comic::class,
            parentColumns = ["id"],
            childColumns = ["comicId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class CreatorSummary: BaseRoleSummary() {

    val comicId: Int? = null
}
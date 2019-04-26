package com.lyapov.marvelcomics.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(
    tableName = "TextObjects", foreignKeys = [
        ForeignKey(
            entity = Comic::class,
            parentColumns = ["id"],
            childColumns = ["comicId"],
            onDelete = CASCADE
        )
    ]
)
class TextObject {

    @Expose
    @SerializedName("type")
    val type: String? = null

    @Expose
    @SerializedName("language")
    val language: String? = null

    @Expose
    @SerializedName("text")
    val text: String? = null

    val comicId: Int? = null
}
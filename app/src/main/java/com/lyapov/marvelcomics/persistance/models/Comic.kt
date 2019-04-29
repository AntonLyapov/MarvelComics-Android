package com.lyapov.marvelcomics.persistance.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.lyapov.marvelcomics.persistance.models.base.BaseDatabaseModel
import com.lyapov.marvelcomics.persistance.models.list.CharacterList
import com.lyapov.marvelcomics.persistance.models.list.CreatorList
import com.lyapov.marvelcomics.persistance.models.list.EventList
import com.lyapov.marvelcomics.persistance.models.list.StoryList
import com.lyapov.marvelcomics.persistance.models.summary.ComicSummary
import com.lyapov.marvelcomics.persistance.models.summary.SeriesSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "Comics")
data class Comic(

    @PrimaryKey
    var id: Int? = null,

    var digitalId: Int? = null,

    var title: String? = null,

    var issueNumber: Int? = null,

    var variantDescription: String? = null,

    var description: String? = null,

    var modified: String? = null,

    var isbn: String? = null,

    var upc: String? = null,

    var diamondCode: String? = null,

    var ean: String? = null,

    var issn: String? = null,

    var format: String? = null,

    var pageCount: Int? = null,

    @Embedded(prefix = "textObjects")
    val textObjects: ArrayList<TextObject>? = null,

    var resourceURI: String? = null,

    @Embedded(prefix = "urls")
    val urls: ArrayList<Url>? = null,

    @Embedded(prefix = "series")
    var series: SeriesSummary? = null,

    @Embedded(prefix = "variants")
    val variants: ArrayList<ComicSummary>? = null,

    @Embedded(prefix = "collections")
    val collections: ArrayList<ComicSummary>? = null,

    @Embedded(prefix = "collectedIssues")
    val collectedIssues: ArrayList<ComicSummary>? = null,

    @Embedded(prefix = "dates")
    val dates: ArrayList<ComicDate>? = null,

    @Embedded(prefix = "prices")
    val prices: ArrayList<ComicPrice>? = null,

    @Embedded(prefix = "thumbnail")
    var thumbnail: Image? = null,

    @Embedded(prefix = "images")
    val images: ArrayList<Image>? = null,

    @Embedded(prefix = "creators")
    var creators: CreatorList? = null,

    @Embedded(prefix = "characters")
    var characters: CharacterList? = null,

    @Embedded(prefix = "stories")
    var stories: StoryList? = null,

    @Embedded(prefix = "events")
    var events: EventList? = null
) : BaseDatabaseModel() {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.createTypedArrayList(TextObject.CREATOR),
        parcel.readString(),
        parcel.createTypedArrayList(Url.CREATOR),
        parcel.readParcelable(SeriesSummary::class.java.classLoader),
        parcel.createTypedArrayList(ComicSummary.CREATOR),
        parcel.createTypedArrayList(ComicSummary.CREATOR),
        parcel.createTypedArrayList(ComicSummary.CREATOR),
        parcel.createTypedArrayList(ComicDate.CREATOR),
        parcel.createTypedArrayList(ComicPrice.CREATOR),
        parcel.readParcelable(Image::class.java.classLoader),
        parcel.createTypedArrayList(Image.CREATOR),
        parcel.readParcelable(CreatorList::class.java.classLoader),
        parcel.readParcelable(CharacterList::class.java.classLoader),
        parcel.readParcelable(StoryList::class.java.classLoader),
        parcel.readParcelable(EventList::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id ?: 0)
        parcel.writeInt(digitalId ?: 0)
        parcel.writeString(title)
        parcel.writeInt(issueNumber ?: 0)
        parcel.writeString(variantDescription)
        parcel.writeString(description)
        parcel.writeString(modified)
        parcel.writeString(isbn)
        parcel.writeString(upc)
        parcel.writeString(diamondCode)
        parcel.writeString(ean)
        parcel.writeString(issn)
        parcel.writeString(format)
        parcel.writeInt(pageCount ?: 0)
        parcel.writeTypedList(textObjects)
        parcel.writeString(resourceURI)
        parcel.writeTypedList(urls)
        parcel.writeParcelable(series, flags)
        parcel.writeTypedList(variants)
        parcel.writeTypedList(collections)
        parcel.writeTypedList(collectedIssues)
        parcel.writeTypedList(dates)
        parcel.writeTypedList(prices)
        parcel.writeParcelable(thumbnail, flags)
        parcel.writeTypedList(images)
        parcel.writeParcelable(creators, flags)
        parcel.writeParcelable(characters, flags)
        parcel.writeParcelable(stories, flags)
        parcel.writeParcelable(events, flags)
    }

    companion object CREATOR : Parcelable.Creator<Comic> {
        override fun createFromParcel(parcel: Parcel): Comic {
            return Comic(parcel)
        }

        override fun newArray(size: Int): Array<Comic?> {
            return arrayOfNulls(size)
        }
    }
}
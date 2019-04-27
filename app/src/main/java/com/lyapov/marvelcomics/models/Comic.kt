package com.lyapov.marvelcomics.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.lyapov.marvelcomics.models.base.BaseParcelableModel
import com.lyapov.marvelcomics.models.list.CharacterList
import com.lyapov.marvelcomics.models.list.CreatorList
import com.lyapov.marvelcomics.models.list.EventList
import com.lyapov.marvelcomics.models.list.StoryList
import com.lyapov.marvelcomics.models.summary.ComicSummary
import com.lyapov.marvelcomics.models.summary.SeriesSummary

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

    @Ignore
    @Embedded(prefix = "textObjects")
    val textObjects: Array<TextObject>? = null,

    @Ignore
    @Embedded(prefix = "resourceURI")
    val resourceURI: String? = null,

    @Ignore
    @Embedded(prefix = "urls")
    val urls: Array<Url>? = null,

    @Ignore
    @Embedded(prefix = "series")
    var series: SeriesSummary? = null,

    @Ignore
    @Embedded(prefix = "variants")
    val variants: Array<ComicSummary>? = null,

    @Ignore
    @Embedded(prefix = "collections")
    val collections: Array<ComicSummary>? = null,

    @Ignore
    @Embedded(prefix = "collectedIssues")
    val collectedIssues: Array<ComicSummary>? = null,

    @Ignore
    @Embedded(prefix = "dates")
    val dates: Array<ComicDate>? = null,

    @Ignore
    @Embedded(prefix = "prices")
    val prices: Array<ComicPrice>? = null,

    @Ignore
    @Embedded(prefix = "thumbnail")
    var thumbnail: Image? = null,

    @Ignore
    @Embedded(prefix = "images")
    val images: Array<Image>? = null,

    @Ignore
    @Embedded(prefix = "creators")
    val creators: CreatorList? = null,

    @Ignore
    @Embedded(prefix = "characters")
    val characters: CharacterList? = null,

    @Ignore
    @Embedded(prefix = "stories")
    val stories: StoryList? = null,

    @Ignore
    @Embedded(prefix = "events")
    val events: EventList? = null
) : BaseParcelableModel() {

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
        parcel.createTypedArray(TextObject.CREATOR),
        parcel.readString(),
        parcel.createTypedArray(Url.CREATOR) as? Array<Url>,
        parcel.readParcelable(SeriesSummary::class.java.classLoader),
        parcel.createTypedArray(ComicSummary.CREATOR) as? Array<ComicSummary>,
        parcel.createTypedArray(ComicSummary.CREATOR) as? Array<ComicSummary>,
        parcel.createTypedArray(ComicSummary.CREATOR) as? Array<ComicSummary>,
        parcel.createTypedArray(ComicDate.CREATOR) as? Array<ComicDate>,
        parcel.createTypedArray(ComicPrice.CREATOR) as? Array<ComicPrice>,
        parcel.readParcelable(Image::class.java.classLoader),
        parcel.createTypedArray(Image.CREATOR) as? Array<Image>,
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
        parcel.writeParcelableArray(textObjects, flags)
        parcel.writeString(resourceURI)
        parcel.writeParcelableArray(urls, flags)
        parcel.writeParcelable(series, flags)
        parcel.writeParcelableArray(variants, flags)
        parcel.writeParcelableArray(collections, flags)
        parcel.writeParcelableArray(collectedIssues, flags)
        parcel.writeParcelableArray(dates, flags)
        parcel.writeParcelableArray(prices, flags)
        parcel.writeParcelable(thumbnail, flags)
        parcel.writeParcelableArray(images, flags)
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
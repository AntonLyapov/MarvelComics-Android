package com.lyapov.marvelcomics.models

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lyapov.marvelcomics.models.summary.SeriesSummary

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "Comics")
class Comic: BaseDatabaseModel()
//    var id: Int?,
//    var digitalId: Int?,
//    var title: String?,
//    var issueNumber: Int?,
//    var variantDescription: String?,
//    var description: String?,
//    var modified: String?,
//    var isbn: String?,
//    var upc: String?,
//    var diamondCode: String?,
//    var ean: String?,
//    var issn: String?,
//    var format: String?,
//    var pageCount: Int?,
//    var textObjects: Array<TextObject>?,
//    var resourceURI: String?,
//    var urls: Array<Url>?,
//    var series: SeriesSummary?,
//    var variants: Array<ComicSummary>?,
//    var collections: Array<ComicSummary>?,
//    var collectedIssues: Array<ComicSummary>?,
//    var dates: Array<ComicDate>?,
//    var prices: Array<ComicPrice>?,
//    var thumbnail: Image?,
//    var images: Array<Image>?,
//    var creators: CreatorList?,
//    var characters: CharacterList?,
//    var stories: StoryList?,
//    var events: EventList?
//)
{
//
//    @Expose
//    @SerializedName("id")
//    @PrimaryKey
//    @ColumnInfo(name = "id")
//    val id: Int? = null
//
//    @Expose
//    @SerializedName("digitalId")
//    val digitalId: Int? = null
//
    @Expose
    @SerializedName("title")
    var title: String? = null
//
//    @Expose
//    @SerializedName("issueNumber")
//    val issueNumber: Int? = null
//
    @Expose
    @SerializedName("variantDescription")
    var variantDescription: String? = null
//
//    @Expose
//    @SerializedName("description")
//    val description: String? = null
//
//    @Expose
//    @SerializedName("modified")
//    val modified: String? = null
//
//    @Expose
//    @SerializedName("isbn")
//    val isbn: String? = null
//
//    @Expose
//    @SerializedName("upc")
//    val upc: String? = null
//
//    @Expose
//    @SerializedName("diamondCode")
//    val diamondCode: String? = null
//
//    @Expose
//    @SerializedName("ean")
//    val ean: String? = null
//
//    @Expose
//    @SerializedName("issn")
//    val issn: String? = null
//
//    @Expose
//    @SerializedName("format")
//    val format: String? = null
//
//    @Expose
//    @SerializedName("pageCount")
//    val pageCount: Int? = null
//
//    @Expose
//    @SerializedName("textObjects")
//    val textObjects: Array<TextObject>? = null
//
//    @Expose
//    @SerializedName("resourceURI")
//    val resourceURI: String? = null
//
//    @Expose
//    @SerializedName("urls")
//    val urls: Array<Url>? = null
//
    @Expose
    @SerializedName("series")
    @Embedded(prefix = "series")
    var series: SeriesSummary? = null
//
//    @Expose
//    @SerializedName("variants")
//    val variants: Array<ComicSummary>? = null
//
//    @Expose
//    @SerializedName("collections")
//    val collections: Array<ComicSummary>? = null
//
//    @Expose
//    @SerializedName("collectedIssues")
//    val collectedIssues: Array<ComicSummary>? = null
//
//    @Expose
//    @SerializedName("dates")
//    val dates: Array<ComicDate>? = null
//
//    @Expose
//    @SerializedName("prices")
//    val prices: Array<ComicPrice>? = null
//
    @Expose
    @SerializedName("thumbnail")
    @Embedded(prefix = "thumbnail")
    var thumbnail: Image? = null
//
//    @Expose
//    @SerializedName("images")
//    val images: Array<Image>? = null
//
//    @Expose
//    @SerializedName("creators")
//    val creators: CreatorList? = null
//
//    @Expose
//    @SerializedName("characters")
//    val characters: CharacterList? = null
//
//    @Expose
//    @SerializedName("stories")
//    val stories: StoryList? = null
//
//    @Expose
//    @SerializedName("events")
//    val events: EventList? = null
}
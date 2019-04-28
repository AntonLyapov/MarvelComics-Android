package com.lyapov.marvelcomics.network.serializers

import com.google.gson.*
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class DateSerializer: JsonSerializer<Date>, JsonDeserializer<Date> {

    override fun serialize(src: Date?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        if (src == null) {
            return context!!.serialize(null)
        }

        return context!!.serialize(src)
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date? {
        if (json == null) {
            return null
        }

        if (!json.isJsonPrimitive) {
            return null
        }

        val value = json.asString

        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.US)

        return try {
            dateFormat.parse(value)
        } catch (ex: ParseException) {
            null
        }
    }

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    }
}
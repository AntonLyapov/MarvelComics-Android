package com.lyapov.marvelcomics.persistance.models.summary

import androidx.room.Entity

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
@Entity(tableName = "SeriesSummaries")
class SeriesSummary(
    resourceURI: String?,
    name: String?
): BaseSummary(resourceURI, name)
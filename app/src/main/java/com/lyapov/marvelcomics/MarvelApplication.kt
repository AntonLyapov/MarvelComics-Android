package com.lyapov.marvelcomics

import androidx.multidex.MultiDexApplication
import com.lyapov.marvelcomics.di.component.DaggerApplicationComponent

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class MarvelApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent.create()
            .inject(this)
    }

    companion object {
        lateinit var instance: MarvelApplication private set
    }
}
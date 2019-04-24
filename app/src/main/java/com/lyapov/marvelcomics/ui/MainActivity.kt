package com.lyapov.marvelcomics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lyapov.marvelcomics.R
import javax.inject.Inject
import com.lyapov.marvelcomics.api.MarvelApiService


/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class MainActivity : AppCompatActivity() {

//    @Inject
//    var marvelApiService: MarvelApiService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://gateway.marvel.com:443/v1/public/comics?apikey=8bf61f3a29c9384471be1b7e91e6c6ec
    }
}

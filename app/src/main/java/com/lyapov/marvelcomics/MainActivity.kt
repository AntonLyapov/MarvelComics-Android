package com.lyapov.marvelcomics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://gateway.marvel.com:443/v1/public/comics?apikey=8bf61f3a29c9384471be1b7e91e6c6ec
    }
}

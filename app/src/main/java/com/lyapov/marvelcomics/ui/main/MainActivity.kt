package com.lyapov.marvelcomics.ui.main

import android.os.Bundle
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.ui.base.BaseActivity
import com.lyapov.marvelcomics.ui.main.list.ComicsFragment


/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class MainActivity : BaseActivity() {
    override fun layoutResId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.content, ComicsFragment()).commit()
        }
    }
}

package com.lyapov.marvelcomics.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.base.BaseActivity
import com.lyapov.marvelcomics.persistance.models.Comic
import com.lyapov.marvelcomics.ui.details.content.DetailsFragment

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class DetailsActivity: BaseActivity() {

    lateinit var comic: Comic

    override fun layoutResId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            comic = intent.getParcelableExtra(EXTRA_COMIC)

            supportFragmentManager.beginTransaction()
                .add(R.id.content, DetailsFragment())
                .commit()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = comic.title
    }

    companion object {

        private const val EXTRA_COMIC = "com.lyapov.marvelcomics.ui.details.DetailsActivity.comic"

        fun getStartingIntent(context: Context, comic: Comic): Intent {
            return Intent(context, DetailsActivity::class.java)
                .apply {
                    putExtra(EXTRA_COMIC, comic)
                }
        }
    }
}
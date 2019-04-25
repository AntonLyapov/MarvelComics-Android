package com.lyapov.marvelcomics.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity() {

    @LayoutRes
    abstract fun layoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId())
    }
}
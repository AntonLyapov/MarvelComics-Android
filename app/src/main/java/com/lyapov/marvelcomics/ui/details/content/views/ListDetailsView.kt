package com.lyapov.marvelcomics.ui.details.content.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ListDetailsView: LinearLayout {
    constructor(context: Context): this(context, null)

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): this(context, attrs, defStyleAttr, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes) {
        orientation = VERTICAL
    }

    fun setCaption(caption: String?) {
        val textView = AppCompatTextView(context)
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.text = caption
        addView(textView)
    }

    fun setValue(value: String?) {
        val textView = AppCompatTextView(context)
        textView.text = value
        addView(textView)
    }
}
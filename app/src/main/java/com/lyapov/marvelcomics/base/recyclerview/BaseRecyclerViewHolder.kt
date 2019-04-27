package com.lyapov.marvelcomics.base.recyclerview

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
abstract class BaseRecyclerViewHolder<T> : RecyclerView.ViewHolder {

    protected var onItemClickListener: BaseRecyclerAdapter.OnItemClickListener? = null

    constructor(itemView: View) : this(itemView, null)

    constructor(itemView: View, onItemClickListener: BaseRecyclerAdapter.OnItemClickListener?) : super(itemView) {
        this.onItemClickListener = onItemClickListener
    }

    abstract fun setData(data: T)

    protected val context: Context
        get() = itemView.context
}
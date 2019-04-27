package com.lyapov.marvelcomics.ui.main.content.adapter

import android.view.ViewGroup
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.base.recyclerview.BaseRecyclerAdapter
import com.lyapov.marvelcomics.models.Comic

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsAdapter(onItemClickListener: OnItemClickListener?) : BaseRecyclerAdapter<Comic, ComicViewHolder>(onItemClickListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = getView(R.layout.item_comic, parent)

        return ComicViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val item = getItem(position)

        holder.setData(item)
    }
}
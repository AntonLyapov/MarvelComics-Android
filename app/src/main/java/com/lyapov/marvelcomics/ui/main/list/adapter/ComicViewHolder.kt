package com.lyapov.marvelcomics.ui.main.list.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.lyapov.marvelcomics.base.recyclerview.BaseRecyclerAdapter
import com.lyapov.marvelcomics.base.recyclerview.BaseRecyclerViewHolder
import com.lyapov.marvelcomics.models.Comic
import kotlinx.android.synthetic.main.item_comic.view.*

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicViewHolder(itemView: View, onItemClickListener: BaseRecyclerAdapter.OnItemClickListener?) :
    BaseRecyclerViewHolder<Comic>(itemView, onItemClickListener) {

    init {
        itemView.setOnClickListener {
            onItemClickListener?.onItemClicked(adapterPosition)
        }
    }

    override fun setData(data: Comic) {
        val thumb = data.thumbnail
        Glide.with(itemView)
            .load("${thumb?.path}.${thumb?.extension}")
            .into(itemView.thumbImageView)

        itemView.titleTextView.text = data.title
        itemView.descriptionTextView.text = data.variantDescription
    }
}
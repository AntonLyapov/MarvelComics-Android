package com.lyapov.marvelcomics.ui.main.content.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.base.recyclerview.BaseRecyclerAdapter
import com.lyapov.marvelcomics.base.recyclerview.BaseRecyclerViewHolder
import com.lyapov.marvelcomics.persistance.models.Comic
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

        itemView.thumbImageView.layout(0,0, 0, 0)
        Glide.with(itemView)
            .load("${thumb?.path}.${thumb?.extension}")
            .placeholder(R.drawable.ic_launcher_background)
            .into(itemView.thumbImageView)

        itemView.titleTextView.text = data.title
        itemView.descriptionTextView.text = data.variantDescription
    }
}
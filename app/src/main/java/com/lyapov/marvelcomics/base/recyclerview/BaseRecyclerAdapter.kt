package com.lyapov.marvelcomics.base.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
abstract class BaseRecyclerAdapter<T, VH : RecyclerView.ViewHolder>() : RecyclerView.Adapter<VH>() {

    interface OnItemClickListener {
        fun onItemClicked(position: Int)
    }

    private val data: MutableList<T> by lazy {
        mutableListOf<T>()
    }

    protected var onItemClickListener: OnItemClickListener? = null

    constructor(onItemClickListener: OnItemClickListener?) : this() {
        this.onItemClickListener = onItemClickListener
    }

    override fun getItemCount(): Int = data.size

    fun add(item: T?) {
        item?.let {
            data.add(item)
            notifyDataSetChanged()
        }
    }

    fun addAll(items: List<T>?) {
        items?.let {
            data.addAll(items)
            notifyDataSetChanged()
        }
    }

    fun clearAndAddAll(items: List<T>?) {
        data.clear()
        items?.let {
            data.addAll(items)
        }
        notifyDataSetChanged()
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    fun clearAnimated() {
        val itemCount = data.count()
        data.clear()
        notifyItemRangeRemoved(0, itemCount)
    }

    fun getItem(position: Int): T {
        return data[position]
    }

    fun getItems(): List<T> {
        return data
    }

    fun removeItemAt(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeItems(items: List<T>) {
        data.removeAll(items)
        notifyDataSetChanged()
    }

    fun getView(layoutResId: Int, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(parent.context)

        return layoutInflater.inflate(layoutResId, parent, false)
    }
}
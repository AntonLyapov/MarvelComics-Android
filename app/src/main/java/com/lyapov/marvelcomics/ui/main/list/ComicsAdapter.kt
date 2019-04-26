package com.lyapov.marvelcomics.ui.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.models.Comic
import kotlinx.android.synthetic.main.item_comic.view.*

class ComicsAdapter : RecyclerView.Adapter<ComicsAdapter.ComicViewHolder>() {

    private val data = ArrayList<Comic>()

    fun setData(data: ArrayList<Comic>?) {
        this.data.clear()
        if (data == null) {
            notifyDataSetChanged()
            return
        }

        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comic, parent, false)

        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val item = data[position]

        holder.setData(item)
    }


    inner class ComicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun setData(comic: Comic) {
            val thumb = comic.thumbnail
            Glide.with(itemView)
                .load("${thumb?.path}.${thumb?.extension}")
                .into(itemView.thumbImageView)

            itemView.titleTextView.text = comic.title
            itemView.descriptionTextView.text = comic.series?.name
        }
    }
}
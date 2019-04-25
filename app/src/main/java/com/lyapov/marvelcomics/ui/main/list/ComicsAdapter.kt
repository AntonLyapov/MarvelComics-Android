package com.lyapov.marvelcomics.ui.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.models.Comic

class ComicsAdapter : RecyclerView.Adapter<ComicsAdapter.ComicViewHolder>() {

    private val data = ArrayList<Comic>()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comic, parent, false)

        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class ComicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}
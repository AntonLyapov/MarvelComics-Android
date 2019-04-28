package com.lyapov.marvelcomics.ui.details.content

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.base.BaseFragment
import com.lyapov.marvelcomics.persistance.models.Comic
import kotlinx.android.synthetic.main.fragment_details.*

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class DetailsFragment: BaseFragment<DetailsViewModel>() {

    private var comic: Comic? = null

    override fun getViewModelClass(): Class<DetailsViewModel> {
        return DetailsViewModel::class.java
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_details
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        comic = arguments?.getParcelable(ARG_COMIC)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thumb = comic?.thumbnail

        Glide.with(view.context)
            .load("${thumb?.path}.${thumb?.extension}")
            .placeholder(R.drawable.ic_launcher_background)
            .into(thumbImageView)

        titleTextView.text = comic?.title
        publishedTextVIew.text = comic?.modified

        listDetailsView.setData()
        listDetailsView.setData()
        listDetailsView.setData()
        listDetailsView.setData()
    }

    companion object {

        private const val ARG_COMIC = "Comic"

        fun createFragment(comic: Comic): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_COMIC, comic)
                }
            }
        }
    }
}
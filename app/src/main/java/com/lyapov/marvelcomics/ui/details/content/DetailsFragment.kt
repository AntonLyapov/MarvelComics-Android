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

        // Set ImageView height to 1/2 of screen
        thumbImageView.layoutParams.height = resources.displayMetrics.heightPixels / 2

        val thumb = comic?.thumbnail

        Glide.with(view.context)
            .load("${thumb?.path}.${thumb?.extension}")
            .placeholder(R.drawable.ic_launcher_background)
            .centerCrop()
            .into(thumbImageView)

        titleTextView.text = comic?.title

        val printPrice = comic?.prices?.first {
            it.type.equals("printPrice")
        }

        val price = printPrice?.price?.toString() ?: "-"
        priceTextVIew.text = context?.getString(R.string.fragment_details_price, price)

        val creators = comic?.creators?.items
        if (creators?.isNotEmpty() == true) {
            creatorsDetailsView.setCaption(context?.getString(R.string.fragment_details_creators))
            creators.forEach { item ->
                creatorsDetailsView.setValue("• ${item.role}: ${item.name}")
            }
        }

        val textObjects = comic?.textObjects
        if (textObjects?.isNotEmpty() == true) {
            textsDetailsView.setCaption(context?.getString(R.string.fragment_details_description))
            comic?.textObjects?.forEach { item ->
                textsDetailsView.setValue("${item.text}")
            }
        }
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
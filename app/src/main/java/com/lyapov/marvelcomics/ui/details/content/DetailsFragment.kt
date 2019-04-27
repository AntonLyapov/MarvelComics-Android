package com.lyapov.marvelcomics.ui.details.content

import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.base.BaseFragment

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class DetailsFragment: BaseFragment<DetailsViewModel>() {

    override fun getViewModelClass(): Class<DetailsViewModel> {
        return DetailsViewModel::class.java
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_details
    }
}
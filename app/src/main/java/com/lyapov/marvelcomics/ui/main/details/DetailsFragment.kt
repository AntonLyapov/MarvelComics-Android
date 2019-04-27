package com.lyapov.marvelcomics.ui.main.details

import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.base.BaseFragment

class DetailsFragment: BaseFragment<DetailsViewModel>() {

    override fun getViewModelClass(): Class<DetailsViewModel> {
        return DetailsViewModel::class.java
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_details
    }
}
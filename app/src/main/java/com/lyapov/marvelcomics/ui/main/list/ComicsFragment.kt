package com.lyapov.marvelcomics.ui.main.list

import android.os.Bundle
import android.view.View
import com.lyapov.marvelcomics.ui.base.BaseFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import com.lyapov.marvelcomics.R
import kotlinx.android.synthetic.main.fragment_list.*


class ComicsFragment : BaseFragment<ComicsViewModel>() {

    override fun getViewModelClass(): Class<ComicsViewModel> {
        return ComicsViewModel::class.java
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        recyclerView.adapter = ComicsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)

        observableViewModel()
    }

    private fun observableViewModel() {
//        viewModel.getRepos().observe(this, { repos -> if (repos != null) recyclerView.setVisibility(View.VISIBLE) })
//
//        viewModel.getError().observe(this, { isError ->
//            if (isError != null)
//                if (isError) {
//                    errorTextView.setVisibility(View.VISIBLE)
//                    listView.setVisibility(View.GONE)
//                    errorTextView.setText("An Error Occurred While Loading Data!")
//                } else {
//                    errorTextView.setVisibility(View.GONE)
//                    errorTextView.setText(null)
//                }
//        })
//
//        viewModel.getLoading().observe(this, { isLoading ->
//            if (isLoading != null) {
//                loadingView.setVisibility(if (isLoading) View.VISIBLE else View.GONE)
//                if (isLoading) {
//                    errorTextView.setVisibility(View.GONE)
//                    listView.setVisibility(View.GONE)
//                }
//            }
//        })
    }
}
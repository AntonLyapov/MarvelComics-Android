package com.lyapov.marvelcomics.ui.main.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.lyapov.marvelcomics.ui.base.BaseFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import com.lyapov.marvelcomics.R
import kotlinx.android.synthetic.main.fragment_comics.*
import com.google.android.material.snackbar.Snackbar


class ComicsFragment : BaseFragment<ComicsViewModel>() {

    private val adapter = ComicsAdapter()

    override fun getViewModelClass(): Class<ComicsViewModel> {
        return ComicsViewModel::class.java
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_comics
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        observableViewModel()
    }

    private fun observableViewModel() {
        viewModel.getComics()
            .observe(this, Observer { comics ->
                adapter.setData(comics)
            })

        viewModel.getRequestError()
            .observe(this, Observer { requestError ->
                requestError?.let {
                    Snackbar.make(comicsContentLayout, it, Snackbar.LENGTH_LONG)
                        .show()
                }
            })

        viewModel.getLoading()
            .observe(this, Observer {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
            })
    }
}
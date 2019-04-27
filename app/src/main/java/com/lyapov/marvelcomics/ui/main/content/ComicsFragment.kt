package com.lyapov.marvelcomics.ui.main.content

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.lyapov.marvelcomics.R
import com.lyapov.marvelcomics.base.BaseFragment
import com.lyapov.marvelcomics.base.recyclerview.BaseRecyclerAdapter
import com.lyapov.marvelcomics.ui.details.DetailsActivity
import com.lyapov.marvelcomics.ui.main.content.adapter.ComicsAdapter
import kotlinx.android.synthetic.main.fragment_comics.*

/*
 *  *  ****************************************************************
 *  *  *                  Developed by Anton Lyapov                   *
 *  *  *                       www.lyapov.com                         *
 *  *  *                  Copyright by Pixum, 04 2019                 *
 *  *  ****************************************************************
 */
class ComicsFragment : BaseFragment<ComicsViewModel>(), BaseRecyclerAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private val adapter = ComicsAdapter(this)

    override fun getViewModelClass(): Class<ComicsViewModel> {
        return ComicsViewModel::class.java
    }

    override fun layoutResId(): Int {
        return R.layout.fragment_comics
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeRefreshLayout.setOnRefreshListener(this)

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        observableViewModel()
    }

    override fun onRefresh() {
        viewModel.fetchComics()
    }

    override fun onItemClicked(position: Int) {
        val item = adapter.getItem(position)

        context?.let {
            val intent = DetailsActivity.getStartingIntent(it, item)
            startActivity(intent)
        }
    }

    private fun observableViewModel() {
        viewModel.getComics()
            .observe(this, Observer { comics ->
                adapter.clearAndAddAll(comics)
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
                swipeRefreshLayout.isRefreshing = it
            })
    }
}
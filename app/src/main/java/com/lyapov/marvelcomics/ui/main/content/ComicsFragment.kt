package com.lyapov.marvelcomics.ui.main.content

import android.os.Bundle
import android.os.Parcelable
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
class ComicsFragment : BaseFragment<ComicsViewModel>(), BaseRecyclerAdapter.OnItemClickListener,
    SwipeRefreshLayout.OnRefreshListener {

    private val adapter = ComicsAdapter(this)
    private var recyclerViewLayoutManager: LinearLayoutManager? = null

    private var lastSelectedAdapterPosition = DEFAULT_SELECTED_ADAPTER_POSITION

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

        recyclerViewLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = recyclerViewLayoutManager

        recyclerView.adapter = adapter

        observableViewModel()
    }

    override fun onRefresh() {
        viewModel.forceFetchComics()
    }

    override fun onResume() {
        super.onResume()

        scrollToComicIfNeeded()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(EXTRA_SELECTED_ADAPTER_POSITION, lastSelectedAdapterPosition)
        outState.putParcelable(EXTRA_RECYCLER_LAYOUT_MANAGER, recyclerViewLayoutManager?.onSaveInstanceState())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        lastSelectedAdapterPosition =
            savedInstanceState?.getInt(EXTRA_SELECTED_ADAPTER_POSITION, DEFAULT_SELECTED_ADAPTER_POSITION)
                ?: DEFAULT_SELECTED_ADAPTER_POSITION

        if (lastSelectedAdapterPosition == DEFAULT_SELECTED_ADAPTER_POSITION) {
            val recyclerViewLayoutManagerState: Parcelable? =
                savedInstanceState?.getParcelable(EXTRA_RECYCLER_LAYOUT_MANAGER)
            recyclerViewLayoutManager?.onRestoreInstanceState(recyclerViewLayoutManagerState)
        }
    }

    override fun onItemClicked(position: Int) {
        lastSelectedAdapterPosition = position

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

                scrollToComicIfNeeded()
            })

        viewModel.getRequestError()
            .observe(this, Observer { requestError ->
                requestError?.let {
                    Snackbar.make(comicsContentLayout, it, Snackbar.LENGTH_LONG)
                        .show()
                }

                val hasError = requestError.isNullOrEmpty().not()
                errorTextView.visibility = if (hasError) View.VISIBLE else View.GONE
            })

        viewModel.getLoading()
            .observe(this, Observer {
                swipeRefreshLayout.isRefreshing = it
            })
    }

    private fun scrollToComicIfNeeded() {
        if (lastSelectedAdapterPosition >= 0 && lastSelectedAdapterPosition < adapter.itemCount) {
            recyclerViewLayoutManager?.scrollToPositionWithOffset(lastSelectedAdapterPosition, 0)
            lastSelectedAdapterPosition = DEFAULT_SELECTED_ADAPTER_POSITION
        }
    }

    companion object {
        private const val DEFAULT_SELECTED_ADAPTER_POSITION = -1

        private const val EXTRA_SELECTED_ADAPTER_POSITION = "AdapterPosition"
        private const val EXTRA_RECYCLER_LAYOUT_MANAGER = "RecyclerLayoutManager"
    }
}
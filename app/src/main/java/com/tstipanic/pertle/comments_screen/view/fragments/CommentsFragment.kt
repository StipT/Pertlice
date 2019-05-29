package com.tstipanic.pertle.comments_screen.view.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.adapters.CommentRecyclerAdapter
import com.tstipanic.pertle.comments_screen.presenter.CommentsFragPresenter
import com.tstipanic.pertle.comments_screen.view.fragments.base.BaseFragment
import com.tstipanic.pertle.model.Comment
import kotlinx.android.synthetic.main.fragment_comments.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CommentsFragment : BaseFragment(), CommentsFragView {

    private val presenter: CommentsFragPresenter by inject { parametersOf(this) }
    private val adapter = CommentRecyclerAdapter()

    override fun getLayoutResourceId() = R.layout.fragment_comments

    companion object {
        fun newInstance() = CommentsFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }


    override fun initUi() {

        commentRecyclerView.layoutManager = LinearLayoutManager(context)
        commentRecyclerView.adapter = adapter
        configureSwipeRefresh()
        postButton.setOnClickListener { postComment() }
        presenter.fetchComments()

    }

    private fun postComment() {
        val username: String
        if (enterUsername.text.trim().isBlank()) {
            username = getString(R.string.anonymous_username)
        } else {
            username = enterUsername.text.trim().toString()
        }

        if (enterComment.text.isBlank()) {
            enterComment.error = getString(R.string.editComment_error)
        } else {
            val content = enterComment.text.trim().toString()
            val comment = Comment(username, content)
            clearEditTexts()
            presenter.storeComment(comment)
            Toast.makeText(activity?.applicationContext, getString(R.string.comment_added_toast), Toast.LENGTH_SHORT)
                .show()
        }
    }


    private fun clearEditTexts() {
        enterUsername.text.clear()
        enterComment.text.clear()
    }

    override fun populateList(list: List<Comment>) {
        adapter.addItems(list)
    }

    private fun configureSwipeRefresh() {
        swipeLayout.setOnRefreshListener {
            presenter.fetchComments()
            swipeLayout.isRefreshing = false
        }
    }

    override fun showLoader() {
        commentLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        commentLoader.visibility = View.GONE
    }

    override fun showNoServiceToast() {
        Toast.makeText(activity?.applicationContext, getString(R.string.no_service_toast), Toast.LENGTH_LONG).show()
    }
}
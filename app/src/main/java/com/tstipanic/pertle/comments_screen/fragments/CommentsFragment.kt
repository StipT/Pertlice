package com.tstipanic.pertle.comments_screen.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.tstipanic.pertle.common.FirestoreCallback
import com.tstipanic.pertle.model.interactor.Interactor
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.adapters.CommentRecyclerAdapter
import com.tstipanic.pertle.comments_screen.fragments.base.BaseFragment
import com.tstipanic.pertle.model.Comment
import kotlinx.android.synthetic.main.fragment_comments.*

class CommentsFragment : BaseFragment(), FirestoreCallback {

    override fun getLayoutResourceId() = R.layout.fragment_comments

    companion object {
        fun newInstance() = CommentsFragment()
    }

    private val interactor = Interactor()
    private var commentList: List<Comment> = mutableListOf()
    private val adapter = CommentRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {

        commentRecyclerView.layoutManager = LinearLayoutManager(context)
        commentRecyclerView.adapter = adapter
        configureSwipeRefresh()
        interactor.getDataFromDb(this)

        postButton.setOnClickListener { postComment() }

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
            interactor.addDataToDb(comment)
            clearEditTexts()
        }

    }

    private fun clearEditTexts() {
        enterUsername.text.clear()
        enterComment.text.clear()
    }

    override fun onCallback(list: List<Comment>) {
        commentList = list
        adapter.addItems(commentList)
    }

    private fun configureSwipeRefresh() {
        swipeLayout.setOnRefreshListener { interactor.getDataFromDb(this); swipeLayout.isRefreshing = false}
    }


}
package com.tstipanic.pertle.comments_screen.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tstipanic.pertle.R
import com.tstipanic.pertle.model.Comment

class CommentRecyclerAdapter : RecyclerView.Adapter<CommentViewHolder>(){

    private var commentList: MutableList<Comment> = mutableListOf()


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CommentViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.comment_recycler_item, p0, false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (commentList.size >= 10) {
            return 10
        } else {
            return commentList.size
        }
    }

    override fun onBindViewHolder(p0: CommentViewHolder, p1: Int) {
        p0.onBind(commentList, p1)
    }

    fun addItems(list: List<Comment>) {
        commentList.clear()
        commentList = list.toMutableList()
        notifyDataSetChanged()

    }
}
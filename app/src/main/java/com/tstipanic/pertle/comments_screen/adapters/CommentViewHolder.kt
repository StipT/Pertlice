package com.tstipanic.pertle.comments_screen.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.tstipanic.pertle.common.calculateTimePassed
import com.tstipanic.pertle.model.Comment
import kotlinx.android.synthetic.main.comment_recycler_item.view.*

class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    fun onBind(commentList: List<Comment>, position: Int) {
        itemView.commentUsername.text = commentList[position].username
        itemView.contentContent.text = commentList[position].content
        itemView.commentDate.text = calculateTimePassed(commentList[position].timestamp!!.seconds)
    }
}

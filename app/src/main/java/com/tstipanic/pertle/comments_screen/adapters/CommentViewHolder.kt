package com.tstipanic.pertle.comments_screen.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.tstipanic.pertle.model.Comment
import kotlinx.android.synthetic.main.comment_recycler_item.view.*
import java.util.*

class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    fun onBind(commentList: List<Comment>, position: Int) {
        itemView.commentUsername.text = commentList[position].username
        itemView.contentContent.text = commentList[position].content
        itemView.commentDate.text = calculateTime(commentList[position])
    }

    private fun calculateTime(comment: Comment): String {
        var commentTime: Long = 0
        if (comment.timestamp != null) {
            commentTime = comment.timestamp.seconds
        }
        val currentTime: Long = Calendar.getInstance().timeInMillis / 1000

        return when (val timePassed = currentTime - commentTime) {
            in 0..120 -> "Just now"
            in 120..3_600 -> "${(timePassed / 60).toInt()} minutes ago"
            in 3_600..7_200 -> "One hour ago"
            in 7_200..86_400 -> "${(timePassed / 3600)} hours ago"
            in 86_400..Long.MAX_VALUE -> "${(timePassed / 86_400)} days ago"
            else -> "Long time ago"
        }
    }
}

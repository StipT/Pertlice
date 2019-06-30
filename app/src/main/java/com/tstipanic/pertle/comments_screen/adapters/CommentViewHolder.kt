package com.tstipanic.pertle.comments_screen.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.tstipanic.pertle.R
import com.tstipanic.pertle.common.*
import com.tstipanic.pertle.model.Comment
import kotlinx.android.synthetic.main.comment_recycler_item.view.*
import java.util.*

class CommentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


    fun onBind(commentList: List<Comment>, position: Int) {
        itemView.commentUsername.text = commentList[position].username
        itemView.contentContent.text = commentList[position].content
        itemView.commentDate.text = calculateTimePassed(commentList[position].timestamp?.seconds)
    }


    private fun calculateTimePassed(timeOfPosting: Long?): String {
        if (timeOfPosting != null) {
            val currentTime: Long = Calendar.getInstance().timeInMillis / 1000

            return when (val timePassed = currentTime - timeOfPosting) {
                in 0..TWO_MINUTES -> view.context.getString(R.string.comment_date_now)
                in TWO_MINUTES..HOUR -> String.format(
                    view.context.getString(R.string.x_minutes_ago),
                    (timePassed / MINUTE).toInt()
                )
                in HOUR..TWO_HOURS -> view.context.getString(R.string.one_hour_ago)
                in TWO_HOURS..DAY -> String.format(
                    view.context.getString(R.string.x_hours_ago),
                    (timePassed / HOUR).toInt()
                )
                in DAY..TWO_DAYS -> view.context.getString(R.string.one_day_ago)
                in TWO_DAYS..Long.MAX_VALUE -> String.format(
                    view.context.getString(R.string.x_days_ago),
                    (timePassed / DAY).toInt()
                )
                else -> view.context.getString(R.string.long_time_ago)
            }
        } else {
            return "???"
        }
    }
}

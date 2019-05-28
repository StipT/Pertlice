package com.tstipanic.pertle.comments_screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.adapters.CommentsPagerAdapter
import kotlinx.android.synthetic.main.activity_comments.*


class CommentsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
        initUi()
    }

    private fun initUi() {
        commentsViewPager.adapter = CommentsPagerAdapter(supportFragmentManager, this)
        tab.setupWithViewPager(commentsViewPager)
    }


}


package com.tstipanic.pertle.comments_screen.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.adapters.CommentsPagerAdapter
import com.tstipanic.pertle.comments_screen.presenter.CommentsPresenter
import kotlinx.android.synthetic.main.activity_comments.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class CommentsActivity : AppCompatActivity(), CommentsView {

    private val presenter: CommentsPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()
    }


    override fun initUi() {
        setContentView(R.layout.activity_comments)
        commentsViewPager.adapter = CommentsPagerAdapter(supportFragmentManager, this)
        tab.setupWithViewPager(commentsViewPager)
    }
}


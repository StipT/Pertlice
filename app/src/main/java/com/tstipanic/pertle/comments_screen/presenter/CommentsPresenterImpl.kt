package com.tstipanic.pertle.comments_screen.presenter

import com.tstipanic.pertle.comments_screen.view.CommentsView

class CommentsPresenterImpl(val view: CommentsView) : CommentsPresenter {

    override fun onCreate() {
        view.initUi()
    }
}
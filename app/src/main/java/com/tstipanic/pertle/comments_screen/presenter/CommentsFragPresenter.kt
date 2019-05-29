package com.tstipanic.pertle.comments_screen.presenter

import com.tstipanic.pertle.model.Comment

interface CommentsFragPresenter {

    fun onViewCreated()

    fun fetchComments()

    fun storeComment(comment: Comment)


}
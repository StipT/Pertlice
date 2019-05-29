package com.tstipanic.pertle.comments_screen.presenter

import com.tstipanic.pertle.comments_screen.view.fragments.CommentsFragView
import com.tstipanic.pertle.common.FirestoreCallback
import com.tstipanic.pertle.model.Comment
import com.tstipanic.pertle.model.interactor.Interactor


class CommentsFragPresenterImpl(
    val view: CommentsFragView,
    private val interactor: Interactor
) : CommentsFragPresenter, FirestoreCallback {

    override fun onViewCreated() {
        view.initUi()
    }


    override fun onSuccess(list: List<Comment>) {
        view.populateList(list)
        view.hideLoader()
    }

    override fun onFailure() {
        view.showNoServiceToast()
    }

    override fun fetchComments() {
        interactor.getDataFromDb(this)
    }

    override fun storeComment(comment: Comment) {
        interactor.addDataToDb(comment)
    }
}
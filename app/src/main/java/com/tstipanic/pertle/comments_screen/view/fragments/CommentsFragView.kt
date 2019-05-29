package com.tstipanic.pertle.comments_screen.view.fragments

import com.tstipanic.pertle.model.Comment

interface CommentsFragView {

    fun initUi()

    fun populateList(list: List<Comment>)

    fun showLoader()

    fun hideLoader()

    fun showNoServiceToast()
}
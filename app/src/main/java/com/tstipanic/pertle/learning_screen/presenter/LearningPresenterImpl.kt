package com.tstipanic.pertle.learning_screen.presenter

import com.tstipanic.pertle.learning_screen.view.LearningView

class LearningPresenterImpl(val view: LearningView) : LearningPresenter {

    override fun onCreate() {
        view.initUi()
    }

    override fun onBackButton() {
        view.backButtonClick()
    }

    override fun onNextButton() {
        view.nextButtonClick()
    }
}
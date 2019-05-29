package com.tstipanic.pertle.dedication_screen.presenter

import com.tstipanic.pertle.dedication_screen.view.DedicationView

class DedicationPresenterImpl(val view: DedicationView) :
    DedicationPresenter {

    override fun onCreate() {
        view.initUi()
    }

    override fun onStartButton() {
        view.goToLearningActivity()
    }
}
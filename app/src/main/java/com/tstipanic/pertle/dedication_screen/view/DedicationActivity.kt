package com.tstipanic.pertle.dedication_screen.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tstipanic.pertle.R
import com.tstipanic.pertle.dedication_screen.presenter.DedicationPresenter
import com.tstipanic.pertle.learning_screen.view.LearningActivity
import kotlinx.android.synthetic.main.activity_dedication.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DedicationActivity : AppCompatActivity(), DedicationView {

    private val presenter: DedicationPresenter by inject { parametersOf(this) }

    override fun initUi() {
        setContentView(R.layout.activity_dedication)
        startButton.setOnClickListener { presenter.onStartButton() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()

    }

    override fun goToLearningActivity() {
        startActivity(Intent(this, LearningActivity::class.java))
    }
}

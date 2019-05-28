package com.tstipanic.pertle.learning_screen.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.view.CommentsActivity
import com.tstipanic.pertle.learning_screen.pager_adapter.StepsPagerAdapter
import com.tstipanic.pertle.learning_screen.pager_adapter.ZoomOutTransformation
import com.tstipanic.pertle.learning_screen.presenter.LearningPresenter
import com.tstipanic.pertle.model.LearningSteps
import kotlinx.android.synthetic.main.activity_learning.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LearningActivity : AppCompatActivity(), LearningView {

    private val presenter: LearningPresenter by inject { parametersOf(this) }

    private var lastStep = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)
        presenter.onCreate()
    }

    override fun initUi() {
        viewPagerSetup()
        dotsIndicator.setViewPager(viewPager)
        nextButton.setOnClickListener { presenter.onNextButton() }
        backButton.setOnClickListener { presenter.onBackButton() }
    }


    override fun nextButtonClick() {
        if (lastStep) {
            startActivity(Intent(this@LearningActivity, CommentsActivity::class.java))
        } else {
            viewPager.currentItem++
        }
    }

    override fun backButtonClick() {
        viewPager.currentItem--
    }

    private fun whenPageSelected(position: Int) {
        stepTitleText.setText(LearningSteps.list[position].title)
        when (position) {
            0 -> {
                backButton.visibility = View.INVISIBLE
                nextButton.text = getString(R.string.next_button_text)
                lastStep = false
            }
            7 -> {
                lastStep = true
                nextButton.text = getString(R.string.finish_button_text)
                backButton.visibility = View.VISIBLE
            }
            in 1..6 -> {
                backButton.visibility = View.VISIBLE
                nextButton.text = getString(R.string.next_button_text)
                lastStep = false
            }

        }
    }

    private fun viewPagerSetup() {
        viewPager.adapter = StepsPagerAdapter(supportFragmentManager)
        viewPager.clipToPadding = false
        viewPager.setPadding(96, 0, 96, 0)
        viewPager.pageMargin = -150

        viewPager.setPageTransformer(true, ZoomOutTransformation())
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(p0: Int) { whenPageSelected(p0) }
            override fun onPageScrollStateChanged(p0: Int) { }
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) { }
        })
    }
}


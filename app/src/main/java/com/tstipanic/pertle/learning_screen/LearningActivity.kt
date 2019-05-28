package com.tstipanic.pertle.learning_screen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.CommentsActivity
import com.tstipanic.pertle.learning_screen.pager_adapter.StepsPagerAdapter
import com.tstipanic.pertle.learning_screen.pager_adapter.ZoomOutTransformation
import com.tstipanic.pertle.model.LearningSteps
import kotlinx.android.synthetic.main.activity_learning.*

class LearningActivity : AppCompatActivity() {
    private var lastStep = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)
        initUi()
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


    private fun initUi() {
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

        nextButton.setOnClickListener { nextButtonClick() }
        backButton.setOnClickListener { backButtonClick() }

        worm_dots_indicator.setViewPager(viewPager)
    }


    private fun nextButtonClick() {
        if (lastStep) {
            startActivity(Intent(this@LearningActivity, CommentsActivity::class.java))
        } else {
            viewPager.currentItem++
        }
    }


    private fun backButtonClick() {
        viewPager.currentItem--
    }
}


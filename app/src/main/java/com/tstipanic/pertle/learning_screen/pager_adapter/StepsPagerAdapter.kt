package com.tstipanic.pertle.learning_screen.pager_adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.tstipanic.pertle.learning_screen.view.PagerFragment
import com.tstipanic.pertle.model.LearningSteps

class StepsPagerAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment = PagerFragment.newInstance(p0)

    override fun getCount() = LearningSteps.list.size

}
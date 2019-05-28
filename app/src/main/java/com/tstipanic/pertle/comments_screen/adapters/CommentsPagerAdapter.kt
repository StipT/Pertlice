package com.tstipanic.pertle.comments_screen.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.view.fragments.CommentsFragment
import com.tstipanic.pertle.comments_screen.view.fragments.CreditsFragment

class CommentsPagerAdapter (fm: FragmentManager, private val context: Context): FragmentPagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment = when(p0) {
        0 -> CommentsFragment.newInstance()
        1 -> CreditsFragment.newInstance()
        else -> CommentsFragment.newInstance()
    }

    override fun getCount() = 2


    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.comments_tab_title)
        1 -> context.getString(R.string.credits_tab_title)
        else -> ""
    }
}



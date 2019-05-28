package com.tstipanic.pertle.comments_screen.fragments

import android.support.v4.app.Fragment
import com.tstipanic.pertle.R
import com.tstipanic.pertle.comments_screen.fragments.base.BaseFragment

class CreditsFragment: BaseFragment() {
    override fun getLayoutResourceId() = R.layout.fragment_credits

    companion object {
        fun newInstance(): Fragment = CreditsFragment()
    }
}
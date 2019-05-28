package com.tstipanic.pertle.learning_screen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tstipanic.pertle.R
import com.tstipanic.pertle.common.EXTRA_ITEM_POSITION
import com.tstipanic.pertle.model.LearningSteps
import kotlinx.android.synthetic.main.fragment_learning_step.view.*

class PagerFragment: Fragment() {
    companion object {

        fun newInstance(i: Int): PagerFragment {
            val bundle = Bundle()
            val fragment = PagerFragment()
            bundle.putSerializable(EXTRA_ITEM_POSITION, i)
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val position = arguments?.getSerializable(EXTRA_ITEM_POSITION) as Int
        val view = inflater.inflate(R.layout.fragment_learning_step, container, false)
        val learningStep = LearningSteps.list[position]

        view.learningStepImage.setImageResource(learningStep.image)
        view.learningStepDesc.setText(learningStep.instructions)
        view.learningStepDesc.bringToFront()

        return view



    }
}
package com.tstipanic.pertle.learning_screen.pager_adapter

import android.support.v4.view.ViewPager
import android.view.View
import com.tstipanic.pertle.common.MIN_ALPHA
import com.tstipanic.pertle.common.MIN_SCALE


class ZoomOutTransformation : ViewPager.PageTransformer {

    override fun transformPage(p0: View, p1: Float) {
        when (p1) {
            in Float.MIN_VALUE..-1f -> p0.alpha = 0f

            in -1f..1f -> {
                p0.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(p1))
                p0.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(p1))
                p0.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(p1))
            }

            else -> p0.alpha = 0f
        }
    }
}
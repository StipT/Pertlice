package com.tstipanic.pertle.splash_screen.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tstipanic.pertle.R
import com.tstipanic.pertle.dedication_screen.view.DedicationActivity
import com.tstipanic.pertle.splash_screen.presenter.SplashPresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashActivity : AppCompatActivity(), SplashView {

    private val splashPresenter: SplashPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashPresenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.onDestroy()
    }

    override fun setNavigationBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(android.R.color.transparent))
        }
    }

    override fun goToDedicationActivity() {
        val intent = Intent(this, DedicationActivity::class.java)
        startActivity(intent)
        finish()
    }

}



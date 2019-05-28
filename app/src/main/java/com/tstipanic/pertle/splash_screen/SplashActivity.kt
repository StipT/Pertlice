package com.tstipanic.pertle.splash_screen

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tstipanic.pertle.R
import com.tstipanic.pertle.dedication_screen.DedicationActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timerDisposable = Observable
            .timer(1500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ goToDedicationActivity()}, { it.printStackTrace() })
        compositeDisposable.add(timerDisposable)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(android.R.color.transparent))
        }
    }

    private fun goToDedicationActivity() {
        val intent = Intent(this, DedicationActivity::class.java)
        startActivity(intent)
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        if(!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}

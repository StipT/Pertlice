package com.tstipanic.pertle.splash_screen.presenter

import com.tstipanic.pertle.splash_screen.view.SplashView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashPresenterImpl(val view: SplashView) : SplashPresenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        view.setNavigationBarColor()
        splashTimer()
    }

    override fun onDestroy() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    private fun splashTimer() {
        val timerDisposable = Observable
            .timer(1500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.goToDedicationActivity() }, { it.printStackTrace() })
        compositeDisposable.add(timerDisposable)
    }
}



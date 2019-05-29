package com.tstipanic.pertle

import android.app.Application
import com.tstipanic.pertle.di.commentsModule
import com.tstipanic.pertle.di.dedicationModule
import com.tstipanic.pertle.di.learningModule
import com.tstipanic.pertle.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(splashModule, dedicationModule, learningModule, commentsModule)
        }
    }
}
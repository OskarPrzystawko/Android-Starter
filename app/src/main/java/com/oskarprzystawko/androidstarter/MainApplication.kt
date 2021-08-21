package com.oskarprzystawko.androidstarter

import android.app.Application
import com.oskarprzystawko.androidstarter.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var androidActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = androidActivityInjector

    override fun onCreate() {
        super.onCreate()
        initializeDI()
    }

    private fun initializeDI() {
        DaggerAppComponent
            .create()
            .inject(this)
    }
}
package com.oskarprzystawko.androidstarter.di

import com.oskarprzystawko.androidstarter.MainApplication
import com.oskarprzystawko.androidstarter.modules.ping.PingViewModule
import com.oskarprzystawko.androidstarter.ping.PingDataModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        PingDataModule::class,
        PingViewModule::class,
    ]
)
interface AppComponent {
    fun inject(mainApplication: MainApplication)
}
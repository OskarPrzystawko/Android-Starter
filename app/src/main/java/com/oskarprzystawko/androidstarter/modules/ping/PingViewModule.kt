package com.oskarprzystawko.androidstarter.modules.ping

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PingViewModule {

    @ContributesAndroidInjector
    abstract fun bindPingActivity(): PingActivity

    @ContributesAndroidInjector
    abstract fun bindPingFragment(): PingFragment

}
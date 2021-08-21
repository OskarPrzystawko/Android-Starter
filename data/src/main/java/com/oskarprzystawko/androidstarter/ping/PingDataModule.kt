package com.oskarprzystawko.androidstarter.ping

import dagger.Binds
import dagger.Module

@Module
abstract class PingDataModule {

    @Binds
    abstract fun providePingRepo(repo: PingRepoImpl): PingRepo

}
package com.oskarprzystawko.androidstarter.ping

interface PingRepo {
    suspend fun ping(): Result<String>
}
package com.oskarprzystawko.androidstarter.ping

import java.lang.Exception
import javax.inject.Inject

class PingRepoImpl @Inject constructor(): PingRepo {

    override suspend fun ping(): Result<String> {
        return if (Math.random() < 0.5) {
            Result.success("pong")
        } else {
            Result.failure(Exception())
        }
    }
}
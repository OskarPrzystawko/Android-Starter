package com.oskarprzystawko.androidstarter.ping

import javax.inject.Inject

class PingUseCase @Inject constructor(
    private val pingRepo: PingRepo,
) {

    suspend operator fun invoke(): Result<String> {
        return pingRepo.ping()
    }

}
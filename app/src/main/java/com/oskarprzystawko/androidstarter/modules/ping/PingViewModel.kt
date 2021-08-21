package com.oskarprzystawko.androidstarter.modules.ping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oskarprzystawko.androidstarter.androidcommon.viewmodel.Event
import com.oskarprzystawko.androidstarter.ping.PingUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PingViewModel @Inject constructor(
    private val pingUseCase: PingUseCase,
): ViewModel() {

    private val _showPing = MutableLiveData<Event<String>>()
    val showPing = _showPing as LiveData<Event<String>>

    private val _showError = MutableLiveData<Event<String>>()
    val showError = _showError as LiveData<Event<String>>

    fun onClickPing() {
        viewModelScope.launch {
            pingUseCase().fold(
                this@PingViewModel::onPingSuccess,
                this@PingViewModel::onPingFailure,
            )
        }
    }

    private fun onPingSuccess(pingResult: String) {
        viewModelScope.launch {
            _showPing.postValue(Event(pingResult))
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onPingFailure(throwable: Throwable) {
        viewModelScope.launch {
            _showError.postValue(Event("error"))
        }
    }

}
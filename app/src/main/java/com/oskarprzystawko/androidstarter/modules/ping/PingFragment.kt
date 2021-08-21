package com.oskarprzystawko.androidstarter.modules.ping

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.oskarprzystawko.androidstarter.R
import com.oskarprzystawko.androidstarter.common.viewmodel.EventObserver
import com.oskarprzystawko.androidstarter.common.views.BaseFragment
import com.oskarprzystawko.androidstarter.databinding.FragmentPingBinding
import javax.inject.Inject

class PingFragment : BaseFragment(R.layout.fragment_ping) {

    @Inject
    lateinit var viewModel: PingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeObservers()
    }

    override fun onBindingInitialized(binding: ViewDataBinding) {
        if (binding is FragmentPingBinding) {
            binding.viewModel = this@PingFragment.viewModel
        }
    }

    private fun initializeObservers() {
        viewModel.showPing.observe(this, EventObserver {
            showToast(it)
        })
        viewModel.showError.observe(this, EventObserver {
            showToast(it)
        })
    }

    private fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

}
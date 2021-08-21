package com.oskarprzystawko.androidstarter.modules.ping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.oskarprzystawko.androidstarter.R
import com.oskarprzystawko.androidstarter.androidcommon.viewmodel.EventObserver
import com.oskarprzystawko.androidstarter.databinding.FragmentPingBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PingFragment : DaggerFragment(R.layout.fragment_ping) {

    @Inject
    lateinit var viewModel: PingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = createBinding(inflater, container)
        onBindingCreated(binding)
        return binding.root
    }

    private fun createBinding(inflater: LayoutInflater, container: ViewGroup?)
        = FragmentPingBinding.inflate(inflater, container, false)

    private fun onBindingCreated(binding: FragmentPingBinding) {
        binding.viewModel = viewModel
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
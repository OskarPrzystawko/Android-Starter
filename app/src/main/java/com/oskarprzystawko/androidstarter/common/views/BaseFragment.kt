package com.oskarprzystawko.androidstarter.common.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

open class BaseFragment(private val layout: Int) : DaggerFragment(layout) {

    private lateinit var binding: ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        initializeBinding(inflater, container)
        return binding.root
    }

    open fun onBindingInitialized(binding: ViewDataBinding) { }

    private fun initializeBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(
            inflater,
            layout,
            container,
            false
        )
        onBindingInitialized(binding)
    }

}
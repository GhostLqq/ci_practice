package com.slcorelibrary.viewmodel_practice.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    private val mInitializer: Initializer<VB, VM> by lazy {
        Initializer(this)
    }

    protected lateinit var mViewBinding: VB
    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponent()
        initViews()
        loadData()
    }

    // 初始化viewmodel和viewbinding
    private fun initComponent() {
        mViewBinding = mInitializer.initViewBinding(layoutInflater)

    }

    abstract fun initViews()
    abstract fun loadData()
}
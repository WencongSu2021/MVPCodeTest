package com.wencong.mvpcode.base

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment<P : BasePresenter<*, *>?> : Fragment(), Contract.BaseView {
    var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = initPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) {
            mPresenter!!.detach()
            mPresenter = null
        }
    }

    abstract fun initPresenter(): P
}
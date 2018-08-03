package com.example.yangfang.chinasok.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * created by yf on 2018/7/6.
 */
abstract class BaseFragment : Fragment() {
    private var mRootView: View? = null
    lateinit var mActivity: Context

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = context!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater.inflate(setLayoutId(), null)
        }
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView(mRootView)
    }

    abstract fun initView(mRootView: View?)

    abstract fun setLayoutId(): Int

    open fun initData() {}
}
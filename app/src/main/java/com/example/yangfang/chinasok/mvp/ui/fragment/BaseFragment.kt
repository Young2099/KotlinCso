package com.example.yangfang.chinasok.mvp.ui.fragment

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * created by yf on 2018/7/6.
 */
abstract class BaseFragment : Fragment() {
    var mRootView: View? = null
    lateinit var mActivity:Context

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mActivity = activity
        if (mRootView == null){
            mRootView  = inflater!!.inflate(setLayoutId(),null)
        }
        initView(mRootView)

        return mRootView
    }

    abstract fun initView(mRootView: View?)

    abstract fun setLayoutId(): Int

}
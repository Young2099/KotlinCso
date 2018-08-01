package com.example.yangfang.chinasok.presenter

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.example.yangfang.chinasok.base.BasePresenter
import com.example.yangfang.chinasok.util.LogUtil

/**
 * created by yf on 2018/8/1.
 */
class AbsPresenter : BasePresenter {

    override fun onLifecycleChanged(owner: LifecycleOwner, event: OnLifecycleEvent) {
    }

    override fun onCreate(owner: LifecycleOwner) {
        LogUtil.e("onCreate()")
    }

    override fun onDestroy(owner: LifecycleOwner) {
    }


}
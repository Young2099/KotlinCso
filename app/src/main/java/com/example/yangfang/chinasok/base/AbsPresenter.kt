package com.example.yangfang.chinasok.base

import android.arch.lifecycle.LifecycleOwner
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * created by yf on 2018/8/1.
 */
open class AbsPresenter : BasePresenter {
    override fun onCreate(owner: LifecycleOwner) {

    }

    override fun onDestroy(owner: LifecycleOwner) {
        if (mCompositeDisposable != null) {
            mCompositeDisposable!!.clear()
        }
    }


    override fun onStart(owner: LifecycleOwner) {
    }

    override fun onResume(owner: LifecycleOwner) {

    }

    private var mCompositeDisposable: CompositeDisposable? = null

    fun addSubscribe(disposable: Disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(disposable)
    }

}
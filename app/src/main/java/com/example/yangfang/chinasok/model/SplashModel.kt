package com.example.yangfang.chinasok.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.yangfang.chinasok.entity.SplashEntity
import com.example.yangfang.chinasok.presenter.SplashPresenter

/**
 * created by yf on 2018/8/16.
 */
class SplashModel : ViewModel() {

    private lateinit var splashData:LiveData<SplashEntity>
    private lateinit var presenter:SplashPresenter

    fun doAction(time: Long, ids: String) {
        presenter = SplashPresenter()
//        splashData = presenter.getSplashData(time,ids)

    }


}
package com.example.yangfang.chinasok.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.yangfang.chinasok.app.ChinasoApp
import com.example.yangfang.chinasok.inject.component.ActivityComponent
import com.example.yangfang.chinasok.inject.component.DaggerActivityComponent
import com.example.yangfang.chinasok.inject.module.ActivityModule

/**
 * created by yf on 2018/7/5.
 */
abstract class BaseActivity : AppCompatActivity() {

    private lateinit var basePresenter: BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        inject()
        initData()
        initView()
        lifecycle.addObserver(basePresenter)
    }

    open fun inject() {}

    /**
     * 初始化数据
     */

    abstract fun setLayoutId(): Int

    /**
     * 初始化参数
     */
    abstract fun initView()

    open fun initData() {}


    fun getActivityComponent(): ActivityComponent = DaggerActivityComponent.builder()
            .appComponent(ChinasoApp.appComponent)
            .activityModule(getActivityModule()).build()

    private fun getActivityModule(): ActivityModule = ActivityModule(this)


}
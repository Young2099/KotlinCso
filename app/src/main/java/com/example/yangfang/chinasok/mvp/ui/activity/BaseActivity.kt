package com.example.yangfang.chinasok.mvp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.yangfang.chinasok.mvp.app.ChinasoApp
import com.example.yangfang.chinasok.mvp.inject.component.ActivityComponent
import com.example.yangfang.chinasok.mvp.inject.component.DaggerActivityComponent
import com.example.yangfang.chinasok.mvp.inject.module.ActivityModule

/**
 * created by yf on 2018/7/5.
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        inject()
        initData()
        initView()
    }

     open fun inject(){}


    abstract fun initView()

    /**
     * 初始化数据
     */
    open fun initData() {}

    abstract fun setLayoutId(): Int

    fun getActivityComponent(): ActivityComponent = DaggerActivityComponent.builder()
            .appComponent(ChinasoApp.appComponent)
            .activityModule(getActivityModule()).build()

    private fun getActivityModule(): ActivityModule = ActivityModule(this)

}
package com.example.yangfang.chinasok.mvp.inject.component

import com.example.yangfang.chinasok.mvp.inject.module.ActivityModule
import com.example.yangfang.chinasok.mvp.inject.scope.ActivityScope
import com.example.yangfang.chinasok.mvp.ui.activity.MainActivity
import dagger.Component

/**
 * created by yf on 2018/7/23.
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}
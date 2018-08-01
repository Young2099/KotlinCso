package com.example.yangfang.chinasok.inject.component

import android.app.Activity
import com.example.yangfang.chinasok.inject.module.ActivityModule
import com.example.yangfang.chinasok.inject.scope.ActivityScope
import com.example.yangfang.chinasok.ui.activity.MainActivity
import dagger.Component

/**
 * created by yf on 2018/7/23.
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
    fun getActivity(): Activity

}
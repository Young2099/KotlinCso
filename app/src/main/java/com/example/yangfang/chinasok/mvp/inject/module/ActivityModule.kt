package com.example.yangfang.chinasok.mvp.inject.module

import android.app.Activity
import com.example.yangfang.chinasok.mvp.inject.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * created by yf on 2018/7/23.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun providerActivity(): Activity = activity
}
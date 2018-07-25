package com.example.yangfang.chinasok.mvp.inject.module

import android.app.Fragment
import com.example.yangfang.chinasok.mvp.inject.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * created by yf on 2018/7/23.
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun providerFragment(): Fragment = fragment
}
package com.example.yangfang.chinasok.inject.component

import com.example.yangfang.chinasok.inject.module.FragmentModule
import com.example.yangfang.chinasok.inject.scope.FragmentScope
import dagger.Component

/**
 * created by yf on 2018/7/23.
 */
@FragmentScope
@Component(dependencies = [AppComponent::class], modules = [FragmentModule::class])
interface FragmentComponent
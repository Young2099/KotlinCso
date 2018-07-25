package com.example.yangfang.chinasok.mvp.inject.component

import com.example.yangfang.chinasok.mvp.inject.module.AppModule
import com.example.yangfang.chinasok.mvp.inject.module.HttpModule
import dagger.Component
import javax.inject.Singleton

/**
 * created by yf on 2018/7/19.
 */
@Singleton
@Component(modules = [AppModule::class, HttpModule::class])
interface AppComponent
package com.example.yangfang.chinasok.mvp.inject.module

import android.content.Context
import com.example.yangfang.chinasok.mvp.app.ChinasoApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * created by yf on 2018/7/19.
 */
@Module
class AppModule(private val app: ChinasoApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = app
}
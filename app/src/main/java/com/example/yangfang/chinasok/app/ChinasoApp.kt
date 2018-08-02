package com.example.yangfang.chinasok.mvp.app

import android.app.Application
import com.example.yangfang.chinasok.inject.component.AppComponent
import com.example.yangfang.chinasok.inject.component.DaggerAppComponent
import com.example.yangfang.chinasok.inject.module.AppModule
import com.example.yangfang.chinasok.inject.module.HttpModule
import com.example.yangfang.chinasok.inject.module.RetrofitModule
import com.example.yangfang.chinasok.inject.module.ServiceModule

/**
 * created by yf on 2018/7/9.
 */
class ChinasoApp : Application() {


    companion object {
        var instance: Application? = null
        fun instance() = instance!!
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = initDagger(this)

    }

    private fun initDagger(app: ChinasoApp): AppComponent =
            DaggerAppComponent
                    .builder()
                    .appModule(AppModule(app))
                    .httpModule(HttpModule())
                    .retrofitModule(RetrofitModule())
                    .serviceModule(ServiceModule())
                    .build()


}
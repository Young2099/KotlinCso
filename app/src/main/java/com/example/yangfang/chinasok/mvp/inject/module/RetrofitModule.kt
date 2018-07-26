package com.example.yangfang.chinasok.mvp.inject.module

import com.example.yangfang.chinasok.mvp.http.CommonRetrofit
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

/**
 * created by yf on 2018/7/25.
 */
@Module
class RetrofitModule {

    /**
     * 最基础的baseUrl
     */
    @Singleton
    @Provides
    fun providerBaseRetrofit(@Named("default") okHttpClient: OkHttpClient): CommonRetrofit {
        return CommonRetrofit(okHttpClient)
    }
}
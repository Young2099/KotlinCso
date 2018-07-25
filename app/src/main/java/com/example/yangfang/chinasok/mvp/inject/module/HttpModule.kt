package com.example.yangfang.chinasok.mvp.inject.module

import com.example.yangfang.chinasok.BuildConfig
import com.example.yangfang.chinasok.mvp.app.ChinasoApp
import com.example.yangfang.chinasok.mvp.util.getCachePath
import com.example.yangfang.chinasok.mvp.util.isNetWorkConnected
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * created by yf on 2018/7/23.
 */
@Module
class HttpModule {

    @Singleton
    @Provides
    @Named("cache")
    fun providerCacheClient(builder: OkHttpClient.Builder): OkHttpClient {
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            builder.addInterceptor(httpLoggingInterceptor)
        }
        val cacheFile = File(getCachePath(ChinasoApp.instance())+"/cache")
        val cache = Cache(cacheFile, 1024 * 1024 * 50)
        val cacheInterceptor = Interceptor { chain ->
            var request: Request = chain.request()
            if (!isNetWorkConnected()) {
                request = chain.request().newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
            }
            return@Interceptor chain.proceed(request).newBuilder().header("Cache-Control", getTime()).removeHeader("Pragma")
                    .build()
        }
        return builder.addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(cacheInterceptor)
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()

    }

    private fun getTime(): String {
        //无网络缓存四周
        return if (isNetWorkConnected())
            "public,max-age=" + 0 else "public,only-if-cached,max-stale=" + 60 * 60 * 24 * 28

    }

    @Singleton
    @Provides
    @Named("default")
    fun providerOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return builder
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
    }

}
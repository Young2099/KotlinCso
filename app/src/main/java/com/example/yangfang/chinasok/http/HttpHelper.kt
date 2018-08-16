package com.example.yangfang.chinasok.http

import com.example.yangfang.chinasok.entity.SplashEntity
import io.reactivex.Flowable

/**
 * created by yf on 2018/7/25.
 */
interface HttpHelper {
    fun getSplashData(time: Long, ids: String):Flowable<SplashEntity>

}
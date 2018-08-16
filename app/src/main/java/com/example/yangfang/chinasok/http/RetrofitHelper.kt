package com.example.yangfang.chinasok.http

import com.example.yangfang.chinasok.entity.SplashEntity
import io.reactivex.Flowable

/**
 * created by yf on 2018/8/16.
 */
class RetrofitHelper:HttpHelper{
    override fun getSplashData(time: Long, ids: String): Flowable<SplashEntity> {
    }

}
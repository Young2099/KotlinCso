package com.example.yangfang.chinasok.http

import com.example.yangfang.chinasok.constants.ConstantsUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * created by yf on 2018/7/23.
 */
class CommonRetrofit(client: OkHttpClient) {

     var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ConstantsUrl.baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()



}
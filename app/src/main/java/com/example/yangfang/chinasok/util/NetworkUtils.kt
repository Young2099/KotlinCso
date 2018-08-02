package com.example.yangfang.chinasok.util

import android.content.Context
import android.net.ConnectivityManager
import com.example.yangfang.chinasok.mvp.app.ChinasoApp

/**
 * created by yf on 2018/7/23.
 */


fun isNetWorkConnected(): Boolean {
    val connectivityManager: ConnectivityManager? = ChinasoApp.instance!!.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return connectivityManager!!.activeNetworkInfo != null

}
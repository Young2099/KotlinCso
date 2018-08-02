package com.example.yangfang.chinasok.util

import com.google.gson.Gson

/**
 * created by yf on 2018/8/2.
 */

/**
 * JSON反序列化方法
 */
inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}
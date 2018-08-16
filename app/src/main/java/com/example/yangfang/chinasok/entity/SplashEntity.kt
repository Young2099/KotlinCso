package com.example.yangfang.chinasok.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * created by yf on 2018/8/2.
 */
@Entity(tableName = "splash")
data class SplashEntity constructor(
        @PrimaryKey
        @SerializedName("id") val id: String){
        constructor():this("")
        @ColumnInfo(name = "img_url")
        val imgUrl: String = ""

        @ColumnInfo(name = "link_url")
        val linkUlr: String = ""
        val title: String = ""
        val type: Int = 0

}
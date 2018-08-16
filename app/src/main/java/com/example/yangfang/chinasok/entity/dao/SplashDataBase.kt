package com.example.yangfang.chinasok.entity.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.yangfang.chinasok.entity.SplashEntity

/**
 * created by yf on 2018/8/16.
 */
@Database(entities = [(SplashEntity::class)], version = 1)
abstract class SplashDataBase : RoomDatabase() {
    abstract fun splashDao(): SplashDao

}
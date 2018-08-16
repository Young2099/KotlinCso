package com.example.yangfang.chinasok.entity.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.yangfang.chinasok.entity.SplashEntity

/**
 * created by yf on 2018/8/16.
 */
@Dao
interface SplashDao {
    @Insert
    fun insert(splashEntity: SplashEntity)

    @Update
    fun updateSplashEntity(splashEntity: SplashEntity)

    @Query("SELECT * FROM splash ")
    fun querySplash(): SplashEntity


}
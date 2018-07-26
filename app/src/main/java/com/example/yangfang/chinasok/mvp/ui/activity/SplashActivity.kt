package com.example.yangfang.chinasok.mvp.ui.activity

import android.Manifest
import com.example.yangfang.chinasok.R
import com.example.yangfang.chinasok.mvp.base.BaseActivity
import com.example.yangfang.kotlindemo.util.SharedPreferenceUtil
import com.yanzhenjie.permission.AndPermission

class SplashActivity : BaseActivity() {

    var firstLaunchSp by SharedPreferenceUtil("app", false)
    override fun setLayoutId(): Int = R.layout.activity_splash

    override fun initView() {
        granted()
    }

    //申请权限
    private fun granted() {
        AndPermission.with(this)
                .runtime()
                .permission(Manifest.permission_group.CAMERA,
                        Manifest.permission_group.STORAGE,
                        Manifest.permission_group.LOCATION)
                .onGranted { startOtherActivity() }
                .start()

    }

    private fun startOtherActivity() {
        val isFirst = firstLaunchSp
//        if (!isFirst)
    }
}

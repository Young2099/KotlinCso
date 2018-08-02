package com.example.yangfang.chinasok.ui.activity

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Message
import com.example.yangfang.chinasok.R
import com.example.yangfang.chinasok.base.BaseActivity
import com.example.yangfang.chinasok.presenter.SplashPresenter
import com.example.yangfang.chinasok.util.Constants.GO_GUIDE
import com.example.yangfang.chinasok.util.Constants.GO_HOME
import com.example.yangfang.chinasok.util.Constants.SPLASH_DELAY_MILLIS
import com.example.yangfang.chinasok.util.commonStartActivity
import com.example.yangfang.kotlindemo.util.SharedPreferenceUtil
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import javax.inject.Inject

class SplashActivity : BaseActivity() {


    @Inject
    lateinit var presenter: SplashPresenter
    private val isFirst by SharedPreferenceUtil("app", true)
    private val ids by SharedPreferenceUtil("splashId", "")


    private var mHandler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg!!.what) {
                GO_HOME ->
                    commonStartActivity(this@SplashActivity, MainActivity().javaClass)
                GO_GUIDE ->
                    commonStartActivity(this@SplashActivity, GuideViewActivity().javaClass)
            }
        }
    }

    override fun setLayoutId(): Int =
            R.layout.activity_splash


    override fun initView() {
        lifecycle.addObserver(presenter)
        granted()
    }

    override fun inject() {
        super.inject()
        getActivityComponent().inject(this)
    }

    /**
     * 权限申请
     */
    private fun granted() {
        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE, Permission.Group.CAMERA)
                .onGranted {
                    startOtherActivity()
                }
                .onDenied { }
                .start()

    }


    private fun startOtherActivity() {
        if (!isFirst) {
            mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS)
            loadSplashData()
            applySplashAnimation()
        } else {
            mHandler.sendEmptyMessage(GO_GUIDE)
        }
    }

    private fun applySplashAnimation() {


    }

    private fun loadSplashData() {
        val time = System.currentTimeMillis()

    }


}

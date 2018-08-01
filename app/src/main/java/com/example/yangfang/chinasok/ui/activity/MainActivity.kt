package com.example.yangfang.chinasok.ui.activity

import android.support.v4.app.Fragment
import android.view.View
import com.example.yangfang.chinasok.R
import com.example.yangfang.chinasok.base.BaseActivity
import com.example.yangfang.chinasok.mvp.app.ChinasoApp
import com.example.yangfang.chinasok.ui.fragment.HomeFragment
import com.example.yangfang.chinasok.ui.fragment.NewsFragment
import com.example.yangfang.chinasok.ui.fragment.VideoFragment
import com.example.yangfang.chinasok.util.addFragment
import com.example.yangfang.chinasok.util.hideFragment
import com.example.yangfang.chinasok.util.showFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {


    private val newsFragment = NewsFragment()
    private val videoFragment = VideoFragment()
    private val homeFragment = HomeFragment()
    private var currentFragment: Fragment? = null
    private var hideFragment: Fragment? = null

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun inject() {
        getActivityComponent().inject(this)
    }

    override fun initView() {
        home_news.setOnClickListener(this)
        home_my.setOnClickListener(this)
        home_video.setOnClickListener(this)
        initFragment()
        ChinasoApp.instance()

    }

    private fun initFragment() {
        supportFragmentManager
        addFragment(newsFragment, R.id.content, "news")
        addFragment(videoFragment, R.id.content, "video")
        addFragment(homeFragment, R.id.content, "home")
        currentFragment = newsFragment
        hideFragment = newsFragment
        showFragment(newsFragment)
        choiceTabState(0)
    }


    private fun choiceTabState(i: Int) {
        clearButton()
        when (i) {
            0 -> {
                home_news.setImageResource(R.mipmap.home_home_pressed)
            }

            1 -> {
                home_video.setImageResource(R.mipmap.home_video_pressed)
            }
            3 -> {
                home_my.setImageResource(R.mipmap.home_my_pressed)
            }
        }

    }

    override fun onClick(view: View) {
        clearButton()
        when (view.id) {
            R.id.home_news -> {
                choiceTabState(0)
                currentFragment = newsFragment
            }
            R.id.home_video -> {
                choiceTabState(1)
                currentFragment = videoFragment
            }
            R.id.home_my -> {
                choiceTabState(3)
                currentFragment = homeFragment
            }

        }
        changeFragment(currentFragment, hideFragment)
        hideFragment = currentFragment
    }

    private fun changeFragment(currentFragment: Fragment?, hideFragment: Fragment?) {
        if (currentFragment!! == hideFragment!!) {
            return
        }
        showFragment(currentFragment)
        hideFragment(hideFragment)
    }

    private fun clearButton() {
        home_news.setImageResource(R.mipmap.home_home_normal)
        home_my.setImageResource(R.mipmap.home_my_normal)
        home_video.setImageResource(R.mipmap.home_video_normal)
    }

    override fun initData() {
        super.initData()
    }


}

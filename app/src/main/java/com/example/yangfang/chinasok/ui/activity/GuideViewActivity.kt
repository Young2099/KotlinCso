package com.example.yangfang.chinasok.ui.activity

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.yangfang.chinasok.R
import com.example.yangfang.chinasok.base.BaseActivity
import com.example.yangfang.chinasok.util.commonStartActivity
import com.example.yangfang.kotlindemo.util.SharedPreferenceUtil
import kotlinx.android.synthetic.main.activity_guide_view.*

class GuideViewActivity : BaseActivity() {

    private var firstLaunchSp by SharedPreferenceUtil("app", false)
    override fun setLayoutId(): Int = R.layout.activity_guide_view
    val imageViews = arrayOfNulls<ImageView>(4)

    override fun initData() {
        super.initData()
        val drawables = arrayOf(R.mipmap.guide_help01, R.mipmap.guide_help02,
                R.mipmap.guide_help03, R.mipmap.guide_help04)
        for (i in drawables.indices) {
            val imageView = ImageView(this)
            imageView.setBackgroundResource(drawables[i])
            imageViews[i] = imageView
        }
    }

    override fun initView() {
        view_pager.adapter = ViewPagerAdapter()
    }

    inner class ViewPagerAdapter : PagerAdapter() {
        override fun isViewFromObject(view: View, arg1: Any): Boolean {
            return view == arg1 as View
        }

        override fun getCount(): Int = imageViews.size

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            if (imageViews[position]!!.parent == null) container.addView(imageViews[position], 0)
            else ((imageViews[position]!!.parent) as ViewGroup).removeView(imageViews[position])
            if (position == imageViews.size - 1) {
                imageViews[position]!!.setOnClickListener {
                    setGuide()
                }
            }

            return imageViews[position % imageViews.size] as Any
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(imageViews[position])

        }

    }

    private fun setGuide() {
        firstLaunchSp = false
        commonStartActivity(GuideViewActivity@ this, MainActivity().javaClass)
        finish()
    }
}

package com.example.yangfang.chinasok.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.example.yangfang.chinasok.R
import com.example.yangfang.chinasok.model.NameModel
import com.example.yangfang.chinasok.util.LogUtil
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * created by yf on 2018/7/6.
 */
class HomeFragment : BaseFragment() {
    override fun initView(mRootView: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nameModel = ViewModelProviders.of(activity!!).get(NameModel::class.java)
        nameModel.getName().observe(this, Observer {
            tv.text = nameModel.getName().value
            LogUtil.e("...."+nameModel.getName().value)
        })
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_home
    }

}
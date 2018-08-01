package com.example.yangfang.chinasok.ui.fragment

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.example.yangfang.chinasok.R
import com.example.yangfang.chinasok.model.NameModel
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * created by yf on 2018/7/6.
 */
class NewsFragment : BaseFragment() {
    override fun initView(mRootView: View?) {
        home_logo.setOnClickListener { _ ->
            cuc = ViewModelProviders.of(activity!!).get(NameModel::class.java)
            cuc!!.setName("jane")
        }
    }

    private var cuc: NameModel? = null


    override fun setLayoutId(): Int {
        return R.layout.fragment_news
    }


}
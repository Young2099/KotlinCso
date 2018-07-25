package com.example.yangfang.chinasok.mvp.util

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.widget.Toast

/**
 * created by yf on 2018/7/6.
 */


fun Activity.toast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}


//开启事务
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
    beginTransaction().commitAllowingStateLoss()
}

//增加fragment
fun Activity.addFragment(fragment: Fragment, content: Int, flag: String) {
    fragmentManager.inTransaction { add(content, fragment, flag).hide(fragment) }
}

fun Activity.replaceFragment(fragment: Fragment, content: Int, flag: String) {
    fragmentManager.inTransaction { replace(content, fragment, flag) }
}

fun Activity.showFragment(fragment: Fragment) {
    fragmentManager.inTransaction { show(fragment) }
}

fun Activity.hideFragment(fragment: Fragment) {
    fragmentManager.inTransaction { hide(fragment) }
}





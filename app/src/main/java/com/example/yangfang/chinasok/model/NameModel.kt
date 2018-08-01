package com.example.yangfang.chinasok.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * created by yf on 2018/7/30.
 */
class NameModel : ViewModel() {
    private var nameModel: MutableLiveData<String>? = null

    fun getName(): LiveData<String> {
        if(nameModel == null) {
            nameModel = MutableLiveData()
        }

        return nameModel as MutableLiveData<String>

    }

    fun setName(s:String) {
        if(nameModel != null) {
            nameModel!!.value = s
        }
    }


}
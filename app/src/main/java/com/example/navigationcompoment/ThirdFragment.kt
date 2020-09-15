package com.example.navigationcompoment

import android.util.Log
import com.example.appchat.ui.base.BaseFragment

class ThirdFragment : BaseFragment() {
    override fun onCreateView(): Int {
        return R.layout.third_fragment
    }

    override fun init() {
    }

    override fun eventHandle() {
    }

    override fun getExtras() {
        var result = ""
        result = arguments?.getString("KEY1", "ERROR").toString()
        Log.e("TAG", result)
    }
}
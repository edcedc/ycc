package com.yyc.xxx.weight.loadCallBack

import com.yyc.xxx.R
import com.kingja.loadsir.callback.Callback


class ErrorCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_error
    }

}
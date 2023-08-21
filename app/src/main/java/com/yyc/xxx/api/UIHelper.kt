package com.yyc.xxx.api

import android.os.Bundle
import androidx.navigation.NavController
import com.blankj.utilcode.util.ActivityUtils
import com.yyc.xxx.MainActivity
import com.yyc.xxx.R
import com.yyc.xxx.ui.act.LoginAct
import me.hgj.jetpackmvvm.ext.navigateAction

class UIHelper private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        fun startMainAct() {
            ActivityUtils.startActivity(MainActivity::class.java)
        }

        /**
         *  登录
         */
        fun startLoginAct() {
            ActivityUtils.startActivity(LoginAct::class.java)
        }

        /**
         *  设置
         */
        fun startSettingFrg(nav: NavController) {
            val bundle = Bundle()
            bundle.putString("key", "test")
            nav.navigateAction(R.id.action_mainfragment_to_settingFragment, bundle)
        }

        /**
         *  警报日记
         */
        fun startAlertJournalFrg(nav: NavController) {
            val bundle = Bundle()
            nav.navigateAction(R.id.action_mainfragment_to_alertJournalFrg, bundle)
        }
    }
}


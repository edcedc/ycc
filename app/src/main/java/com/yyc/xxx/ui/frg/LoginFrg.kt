package com.yyc.xxx.ui.frg

import android.os.Bundle
import android.widget.CompoundButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import com.yyc.xxx.api.UIHelper
import com.yyc.xxx.base.BaseFragment
import com.yyc.xxx.databinding.FLoginBinding
import com.yyc.xxx.ext.showMessage
import com.yyc.xxx.util.CacheUtil
import com.yyc.xxx.viewmodel.LoginModel
import me.hgj.jetpackmvvm.ext.nav
import me.hgj.jetpackmvvm.ext.parseState

/**
 * @Author nike
 * @Date 2023/7/5 14:53
 * @Description
 */
class LoginFrg: BaseFragment<LoginModel, FLoginBinding>() {

    val loginModel: LoginModel by viewModels()

    override fun initView(savedInstanceState: Bundle?) {
        addLoadingObserve(loginModel)
        mDatabind.viewmodel = mViewModel
        mDatabind.click = ProxyClick()

        val user = CacheUtil.getUser()
        if (user != null){
            mViewModel.username.set(user.LoginID)
            mViewModel.password.set(user.Password)
        }
    }

    override fun createObserver() {

    }

    inner class ProxyClick() {
        fun clear(){
            mViewModel.username.set("")
        }

        var onCheckedChangeListener =
            CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                mViewModel.isShowPwd.set(isChecked)
            }
        fun login(){
//            when {
//                mViewModel.username.get().isEmpty() -> showMessage(getString(R.string.error_phone))
//                mViewModel.password.get().isEmpty() -> showMessage(getString(R.string.error_phone))
//                else -> loginModel.login(
//                    mViewModel.username.get(),
//                    mViewModel.password.get()
//                )
//            }
            UIHelper.startMainAct()
        }

        fun toSet(){
            UIHelper.startSettingFrg(nav())
        }

    }

}

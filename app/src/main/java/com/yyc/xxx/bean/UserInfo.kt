package com.yyc.xxx.bean
import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/23
 * 描述　: 账户信息
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class UserInfo(
    var id: String="",
    var loginId: String="",
    var password: String="",
    var code: Int,
) : Parcelable

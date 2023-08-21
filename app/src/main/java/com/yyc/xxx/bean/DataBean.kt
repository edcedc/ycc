package com.yyc.xxx.bean


import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by yc on 2017/8/17.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class DataBean(
    var id: String="",
    var LoginID: String="",
    var RoNo: String="",
    var PImgfile: String="",
    var Password: String="",
) : Parcelable
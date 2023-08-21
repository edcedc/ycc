package com.yc.tea.api

import com.yyc.xxx.bean.DataBean
import retrofit2.http.*


/**
 * Created by xuhao on 2017/11/16.
 * Api 接口
 */

interface ApiService{

    companion object {

        private val url =
//            "192.168.2.18"
//            "192.168.2.31"
            "47.243.120.137"

        var SERVLET_URL = "http://" +
                url + "/RFIDInventoryWebService/MobileWebService.asmx/"

    }

    //登录
    @FormUrlEncoded
    @POST("CheckLogin")
    suspend fun CheckLogin(
        @Field("companyID") companyID: String,
        @Field("loginID") loginID: String,
        @Field("userPwd") userPwd: String
    ): BaseResponseBean<DataBean?>

}
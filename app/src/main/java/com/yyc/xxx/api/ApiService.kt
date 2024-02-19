package com.yc.tea.api

<<<<<<< HEAD
import com.yyc.xxx.bean.BaseResponseBean
=======
>>>>>>> ce8e7e8819075194a7b4bcd7273b98c57137903c
import com.yyc.xxx.bean.DataBean
import retrofit2.http.*


<<<<<<< HEAD
=======
/**
 * Created by xuhao on 2017/11/16.
 * Api 接口
 */

>>>>>>> ce8e7e8819075194a7b4bcd7273b98c57137903c
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
<<<<<<< HEAD
    ): BaseResponseBean<DataBean>
=======
    ): BaseResponseBean<DataBean?>
>>>>>>> ce8e7e8819075194a7b4bcd7273b98c57137903c

}
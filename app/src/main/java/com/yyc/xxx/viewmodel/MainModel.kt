package com.yyc.xxx.viewmodel

import androidx.lifecycle.MutableLiveData
import com.yyc.xxx.bean.DataBean
import com.yyc.xxx.network.stateCallback.ListDataUiState
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.databind.StringObservableField

/**
 * @Author nike
 * @Date 2023/7/7 12:00
 * @Description
 */
class MainModel: BaseViewModel() {

    var triggerLocation = StringObservableField()

    var username = StringObservableField()

    var time = StringObservableField()

    private var pagerNumber = 0


    var listBean: MutableLiveData<ListDataUiState<DataBean>> = MutableLiveData()

//    var urlDataState: MutableLiveData<DataBean> = MutableLiveData()


    fun onRequest(isRefresh: Boolean) {
        if (isRefresh) {
            pagerNumber = 0
        }

        val arrayListOf = arrayListOf<DataBean>()
        for (i in 0..9) {
            val bean = DataBean()
            bean.LoginID = "xxx" + i
            arrayListOf.add(bean)
        }

        val listDataUiState =
            ListDataUiState(
                isSuccess = false,
                errMessage = "xx",
                isRefresh = isRefresh,
                listData = arrayListOf
            )
        listBean.value = listDataUiState
    }

}
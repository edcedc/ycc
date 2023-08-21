package com.yyc.xxx.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yyc.xxx.R
import com.yyc.xxx.bean.DataBean

/**
 * @Author nike
 * @Date 2023/7/7 17:05
 * @Description
 */
class AlertAdapter (data: ArrayList<DataBean>) :
    BaseQuickAdapter<DataBean, BaseViewHolder>(
        R.layout.i_alert, data) {


    init {
//        setAdapterAnimation(SettingUtil.getListMode())
    }

    override fun convert(holder: BaseViewHolder, item: DataBean) {
        //赋值
        item.run {
            holder.setText(R.id.tv_trigger_location, item.LoginID)
        }
    }

}
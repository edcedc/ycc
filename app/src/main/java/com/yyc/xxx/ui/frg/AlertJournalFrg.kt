package com.yyc.xxx.ui.frg

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ConvertUtils
import com.yyc.xxx.R
import com.yyc.xxx.adapter.AlertJournalAdapter
import com.yyc.xxx.bean.DataBean
import com.yyc.xxx.databinding.BTitleRecyclerBinding
import com.yyc.xxx.ext.init
import com.yyc.xxx.ext.initClose
import com.yyc.xxx.ext.loadServiceInit
import com.yyc.xxx.ext.showLoading
import com.yyc.xxx.viewmodel.AlertJournalModel
import com.yyc.xxx.weight.recyclerview.SpaceItemDecoration
import com.kingja.loadsir.core.LoadService
import com.yyc.xxx.base.BaseFragment
import me.hgj.jetpackmvvm.ext.nav

/**
 * @Author nike
 * @Date 2023/7/7 16:51
 * @Description  警报日记
 */
class AlertJournalFrg: BaseFragment<AlertJournalModel, BTitleRecyclerBinding>() {

    //界面状态管理者
    lateinit var loadsir: LoadService<Any>

    val adapter: AlertJournalAdapter by lazy { AlertJournalAdapter(arrayListOf()) }

    private val alertJournalModel: AlertJournalModel by viewModels()


    override fun initView(savedInstanceState: Bundle?) {

        setHasOptionsMenu(true)
        mDatabind.includeToolbar.toolbar.initClose(getString(R.string.alert_journal)) {
            nav().navigateUp()
        }

        //初始化recyclerView
        mDatabind.recyclerView.init(LinearLayoutManager(context), adapter).let {
            it.addItemDecoration(SpaceItemDecoration(0, ConvertUtils.dp2px(8f)))
        }

        //状态页配置
        loadsir = loadServiceInit(mDatabind.swipeRefresh) {
            //点击重试时触发的操作
            loadsir.showLoading()
            mViewModel.onRequest(false)
        }

        //初始化 SwipeRefreshLayout  刷新
        mDatabind.swipeRefresh.init {
            mViewModel.onRequest(false)
        }
    }

    override fun createObserver() {
        super.createObserver()
        val list = ArrayList<DataBean>()
        mViewModel.listBean.observe(viewLifecycleOwner, Observer {
            loadsir.showSuccess()
            val listData = it.listData
            adapter.setList(listData)
        })
    }


    override fun lazyLoadData() {
        //设置界面 加载中
        loadsir.showLoading()
        mViewModel.onRequest(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        mActivity.setSupportActionBar(null)
    }

}
package com.bawei.goods.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bawei.base.ui.activity.BaseMvpActivity
import com.bawei.base.ui.adapter.BaseRecyclerViewAdapter
import com.bawei.goods.R
import com.bawei.goods.common.GoodsConstant
import com.bawei.goods.data.protocol.LiveRealInfo
import com.bawei.goods.injection.component.DaggerLiveInfoComponent
import com.bawei.goods.injection.module.LiveInfoModule
import com.bawei.goods.presenter.LiveInfoPresenter
import com.bawei.goods.presenter.view.LiveInfoView
import com.bawei.goods.ui.adapter.LivesAdapter
import kotlinx.android.synthetic.main.activity_live_list.*
import org.jetbrains.anko.startActivity

class LiveListActivity : BaseMvpActivity<LiveInfoPresenter>(),LiveInfoView {
    lateinit var adapter:LivesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_list)

        initView()
        initData()
        initEvent();
    }

    private fun initEvent() {
        adapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<LiveRealInfo>{
            override fun onItemClick(item: LiveRealInfo, position: Int) {
                startActivity<LiveDetailActivity>(GoodsConstant.KEY_LIVE_ITEM_PATH to item)
            }

        })
    }

    private fun initData() {
        mPresenter.getLiveRealList()
    }

    private fun initView() {
        val linearLayoutManager=LinearLayoutManager(this);
        linearLayoutManager.orientation=LinearLayoutManager.VERTICAL
        mLiveRv.layoutManager=linearLayoutManager
        adapter=LivesAdapter(this)
        mLiveRv.adapter=adapter
    }

    override fun injectComponent() {
        DaggerLiveInfoComponent.builder().activityComponent(mActivityComponent).liveInfoModule(LiveInfoModule()).build().inject(this)
        mPresenter.mView=this
    }

    override fun onSuccess(result: MutableList<LiveRealInfo>?) {
        if (result != null) {
            adapter.setData(result)
        }
    }


}
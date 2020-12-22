package com.bawei.goods.presenter

import com.bawei.base.ext.excute
import com.bawei.base.presenter.BasePresenter
import com.bawei.base.rx.BaseSubscriber
import com.bawei.goods.data.protocol.LiveRealInfo
import com.bawei.goods.presenter.view.LiveInfoView
import com.bawei.goods.service.LiveInfoService
import com.bawei.provider.entity.protocol.BaseResp
import javax.inject.Inject

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class LiveInfoPresenter @Inject constructor() : BasePresenter<LiveInfoView>() {
    @Inject
    lateinit var service:LiveInfoService

    /*
        获取商品列表
     */
    fun getLiveRealList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        service.getLiveRealList().excute(object : BaseSubscriber<BaseResp<MutableList<LiveRealInfo>?>>(mView) {
            override fun onNext(t: BaseResp<MutableList<LiveRealInfo>?>) {
                mView.onSuccess(t.data)
            }
        }, lifecycleProvider)

    }
}
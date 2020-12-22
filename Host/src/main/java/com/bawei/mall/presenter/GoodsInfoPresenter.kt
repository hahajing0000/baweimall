package com.bawei.mall.presenter

import com.bawei.base.ext.excute
import com.bawei.base.presenter.BasePresenter
import com.bawei.base.rx.BaseSubscriber
import com.bawei.goods.data.protocol.GetGoodsListReq
import com.bawei.goods.data.protocol.Goods
import com.bawei.mall.presenter.view.GoodsInfoView
import com.bawei.mall.service.GoodsInfoService
import com.bawei.provider.entity.protocol.BaseResp
import javax.inject.Inject

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class GoodsInfoPresenter @Inject constructor(): BasePresenter<GoodsInfoView>() {
    @Inject
    lateinit var service: GoodsInfoService

    fun getGoodsInfo(req:GetGoodsListReq) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        service.getGoodsInfoList(req).excute(object : BaseSubscriber<BaseResp<MutableList<Goods>?>>(mView){
            override fun onNext(t: BaseResp<MutableList<Goods>?>) {
                super.onNext(t)
                mView.onSuccess(t.data)
            }
        },lifecycleProvider)

    }

}
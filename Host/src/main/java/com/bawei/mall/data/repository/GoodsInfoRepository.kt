package com.bawei.mall.data.repository

import com.bawei.goods.data.protocol.GetGoodsListReq
import com.bawei.goods.data.protocol.Goods
import com.bawei.mall.data.api.GoodsInfoApi
import com.bawei.provider.entity.protocol.BaseResp
import com.bawei.netutilslib.RetrofitFactory
import rx.Observable
import javax.inject.Inject

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class GoodsInfoRepository @Inject constructor() {
    /**
     * 获取推荐商品信息
     */
    fun getCartList(req:GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsInfoApi::class.java).getGoods(req)
    }
}
package com.bawei.mall.service.impl

import com.bawei.base.data.protocol.BaseResp
import com.bawei.goods.data.protocol.GetGoodsListReq
import com.bawei.goods.data.protocol.Goods
import com.bawei.mall.data.repository.GoodsInfoRepository
import com.bawei.mall.service.GoodsInfoService
import rx.Observable
import javax.inject.Inject

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class GoodsInfoServiceImpl @Inject constructor() : GoodsInfoService {
    @Inject
    lateinit var repository: GoodsInfoRepository

    override fun getGoodsInfoList(req: GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>> {
        return repository.getCartList(req)
    }
}
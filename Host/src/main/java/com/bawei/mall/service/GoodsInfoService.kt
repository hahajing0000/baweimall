package com.bawei.mall.service

import com.bawei.base.data.protocol.BaseResp
import com.bawei.goods.data.protocol.GetGoodsListReq
import com.bawei.goods.data.protocol.Goods
import rx.Observable

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
interface GoodsInfoService {
    fun getGoodsInfoList(req: GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>>
}
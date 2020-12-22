package com.bawei.mall.data.api

import com.bawei.goods.data.protocol.GetGoodsListReq
import com.bawei.goods.data.protocol.Goods
import com.bawei.provider.entity.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
interface GoodsInfoApi {
    @POST("goods/getGoodsList")
    fun getGoods(@Body req:GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>>
}
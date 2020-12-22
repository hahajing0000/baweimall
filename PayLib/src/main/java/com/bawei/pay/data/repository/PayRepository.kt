package com.bawei.pay.data.repository


import javax.inject.Inject

import rx.Observable
import com.bawei.pay.data.protocol.GetPaySignReq
import com.bawei.pay.data.protocol.PayOrderReq
import com.bawei.pay.data.api.PayApi
import com.bawei.provider.entity.protocol.BaseResp
import com.zy.netutilslib.RetrofitFactory


/*
   支付数据层
 */
class PayRepository @Inject constructor() {

    /*
        获取支付宝支付签名
     */
    fun getPaySign(orderId: Int, totalPrice: Long): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java).getPaySign(GetPaySignReq(orderId, totalPrice))
    }

    /*
        刷新订单状态已支付
     */
    fun payOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java).payOrder(PayOrderReq(orderId))
    }


}

package com.bawei.order.presenter.view

import com.bawei.base.presenter.view.BaseView
import com.bawei.order.data.protocol.Order

/*
    订单确认页 视图回调
 */
interface OrderConfirmView : BaseView {

    //获取订单回调
    fun onGetOrderByIdResult(result:Order)
    //提交订单回调
    fun onSubmitOrderResult(result:Boolean)
}

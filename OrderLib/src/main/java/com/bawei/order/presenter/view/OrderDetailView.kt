package com.bawei.order.presenter.view

import com.bawei.base.presenter.view.BaseView
import com.bawei.order.data.protocol.Order

/*
    订单详情页 视图回调
 */
interface OrderDetailView : BaseView {

    fun onGetOrderByIdResult(result: Order)
}

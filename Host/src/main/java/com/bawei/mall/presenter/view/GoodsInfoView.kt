package com.bawei.mall.presenter.view

import com.bawei.base.presenter.view.BaseView
import com.bawei.goods.data.protocol.Goods

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
interface GoodsInfoView:BaseView {
    fun onSuccess(result:MutableList<Goods>?)
}
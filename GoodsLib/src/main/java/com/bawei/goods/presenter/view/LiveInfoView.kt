package com.bawei.goods.presenter.view

import com.bawei.base.presenter.view.BaseView
import com.bawei.goods.data.protocol.LiveRealInfo

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
interface LiveInfoView :BaseView {
    fun onSuccess(result:MutableList<LiveRealInfo>?)
}
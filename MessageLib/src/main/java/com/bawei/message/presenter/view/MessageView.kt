package com.bawei.message.presenter.view

import com.bawei.base.presenter.view.BaseView
import com.bawei.message.data.protocol.Message

/*
    消息列表 视图回调
 */
interface MessageView : BaseView {

    //获取消息列表回调
    fun onGetMessageResult(result:MutableList<Message>?)
}

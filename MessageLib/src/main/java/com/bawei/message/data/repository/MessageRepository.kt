package com.bawei.message.data.repository


import javax.inject.Inject

import rx.Observable
import com.bawei.message.data.api.MessageApi
import com.bawei.message.data.protocol.Message
import com.bawei.provider.entity.protocol.BaseResp
import com.bawei.netutilslib.RetrofitFactory


/*
   消息数据层
 */
class MessageRepository @Inject constructor() {

    /*
        获取消息列表
     */
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>> {
        return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }



}

package com.bawei.message.service.impl


import com.bawei.base.ext.convert
import javax.inject.Inject

import rx.Observable
import com.bawei.message.data.protocol.Message
import com.bawei.message.data.repository.MessageRepository
import com.bawei.message.service.MessageService

/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository

    /*
        获取消息列表
     */
    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }

}

package com.bawei.message.data.api

import rx.Observable
import com.bawei.base.data.protocol.BaseResp
import com.bawei.message.data.protocol.Message
import retrofit2.http.POST

/*
    消息 接口
 */
interface MessageApi {

    /*
        获取消息列表
     */
    @POST("msg/getList")
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>>

}

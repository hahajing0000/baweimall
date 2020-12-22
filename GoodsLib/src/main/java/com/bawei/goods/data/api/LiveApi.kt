package com.bawei.goods.data.api


import com.bawei.goods.data.protocol.*
import com.bawei.provider.entity.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
interface LiveApi {

    @POST("live/getLiveList")
    fun getLiveList(@Body req: GetLiveListReq): Observable<BaseResp<MutableList<LiveInfo>?>>

    @POST("live/getLiveRealList")
    fun getLiveRealList(): Observable<BaseResp<MutableList<LiveRealInfo>?>>
}
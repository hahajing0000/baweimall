package com.bawei.goods.data.repository

import com.bawei.base.data.net.RetrofitFactory
import com.bawei.base.data.protocol.BaseResp
import com.bawei.goods.data.api.LiveApi
import com.bawei.goods.data.protocol.LiveRealInfo
import rx.Observable
import javax.inject.Inject

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class LiveInfoRepository @Inject constructor() {
    fun getLiveRealList(): Observable<BaseResp<MutableList<LiveRealInfo>?>>{
        return RetrofitFactory.instance.create(LiveApi::class.java).getLiveRealList()
    }
}
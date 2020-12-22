package com.bawei.goods.service

import com.bawei.goods.data.protocol.LiveRealInfo
import com.bawei.provider.entity.protocol.BaseResp
import rx.Observable

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
interface LiveInfoService {
    fun getLiveRealList(): Observable<BaseResp<MutableList<LiveRealInfo>?>>
}
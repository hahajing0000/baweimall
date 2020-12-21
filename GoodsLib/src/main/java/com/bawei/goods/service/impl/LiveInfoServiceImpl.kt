package com.bawei.goods.service.impl

import com.bawei.base.data.protocol.BaseResp
import com.bawei.goods.data.protocol.LiveRealInfo
import com.bawei.goods.data.repository.LiveInfoRepository
import com.bawei.goods.service.LiveInfoService
import rx.Observable
import javax.inject.Inject

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class LiveInfoServiceImpl @Inject constructor() : LiveInfoService {

    @Inject
    lateinit var repository: LiveInfoRepository

    override fun getLiveRealList(): Observable<BaseResp<MutableList<LiveRealInfo>?>> {
        return repository.getLiveRealList()
    }
}
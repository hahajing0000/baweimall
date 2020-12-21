package com.bawei.mall.injection.module

import com.bawei.mall.service.GoodsInfoService
import com.bawei.mall.service.impl.GoodsInfoServiceImpl
import dagger.Module
import dagger.Provides

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
@Module
class GoodsInfoModule {

    @Provides
    fun provideGoodsInfoService(goodsInfoService: GoodsInfoServiceImpl):GoodsInfoService{
        return goodsInfoService
    }
}
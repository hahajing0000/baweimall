package com.bawei.goods.injection.module

import com.bawei.goods.service.LiveInfoService
import com.bawei.goods.service.impl.LiveInfoServiceImpl
import dagger.Module
import dagger.Provides

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
@Module
class LiveInfoModule {
    @Provides
    fun provideLiveInfoService(impl:LiveInfoServiceImpl):LiveInfoService{
        return impl
    }
}
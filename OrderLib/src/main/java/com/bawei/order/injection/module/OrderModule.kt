package com.bawei.order.injection.module

import com.bawei.order.service.OrderService
import com.bawei.order.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

/*
    订单Module
 */
@Module
class OrderModule {

    @Provides
    fun provideOrderservice(orderService: OrderServiceImpl): OrderService{
        return orderService
    }

}

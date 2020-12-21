package com.bawei.order.injection.component

import com.bawei.base.injection.PerComponentScope
import com.bawei.base.injection.component.ActivityComponent
import com.bawei.order.injection.module.OrderModule
import com.bawei.order.ui.activity.OrderConfirmActivity
import com.bawei.order.ui.activity.OrderDetailActivity
import com.bawei.order.ui.fragment.OrderFragment
import dagger.Component

/*
    订单Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(OrderModule::class))
interface OrderComponent {
    fun inject(activity:OrderConfirmActivity)
    fun inject(fragment:OrderFragment)

    fun inject(activity:OrderDetailActivity)
}

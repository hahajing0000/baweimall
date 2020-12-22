package com.bawei.order.injection.component

import com.bawei.order.injection.module.OrderModule
import com.bawei.order.ui.activity.OrderConfirmActivity
import com.bawei.order.ui.activity.OrderDetailActivity
import com.bawei.order.ui.fragment.OrderFragment
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
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

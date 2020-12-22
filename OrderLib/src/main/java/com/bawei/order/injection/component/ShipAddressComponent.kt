package com.bawei.order.injection.component

import com.bawei.order.injection.module.ShipAddressModule
import com.bawei.order.ui.activity.ShipAddressActivity
import com.bawei.order.ui.activity.ShipAddressEditActivity
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    收货人信息Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ShipAddressModule::class))
interface ShipAddressComponent {
    fun inject(activity: ShipAddressEditActivity)
    fun inject(activity: ShipAddressActivity)
}
